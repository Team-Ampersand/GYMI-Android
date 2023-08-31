package com.mpersand.data.remote.util

import com.mpersand.data.BuildConfig
import com.mpersand.data.local.datasource.LocalDataSource
import com.mpersand.data.remote.model.auth.request.TokenReissueRequest
import com.mpersand.domain.exception.TokenExpiredException
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.time.LocalDateTime
import javax.inject.Inject

class RequestInterceptor @Inject constructor(
    private val moshi: Moshi,
    private val localDataSource: LocalDataSource
) : Interceptor {
    @OptIn(ExperimentalStdlibApi::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val path = request.url.encodedPath
        val ignorePath = listOf("/auth")
        val currentTime = LocalDateTime.now()

        ignorePath.forEach {
            if (path.contains(it)) {
                return chain.proceed(request)
            }
        }

        val refreshToken = runBlocking { localDataSource.getRefreshToken().first() }
        val accessTokenExp = runBlocking { LocalDateTime.parse(localDataSource.getAccessTokenExp().first()) }
        val refreshTokenExp = runBlocking { LocalDateTime.parse(localDataSource.getRefreshTokenExp().first()) }

        if (currentTime.isAfter(refreshTokenExp)) throw TokenExpiredException()

        if (currentTime.isAfter(accessTokenExp)) {
            val client = OkHttpClient()
            val reissueRequest = Request.Builder()
                .url("${BuildConfig.BASE_URL}auth")
                .patch("".toRequestBody("application/json".toMediaType()))
                .addHeader(
                    name = "Refresh-Token",
                    value = "Bearer $refreshToken"
                )
                .build()
            val response = client.newCall(reissueRequest).execute()

            if (response.isSuccessful) {
                val jsonAdapter: JsonAdapter<TokenReissueRequest> = moshi.adapter()
                val token = jsonAdapter.fromJson(response.body!!.string())!!
                runBlocking {
                    localDataSource.saveToken(
                        accessToken = token.accessToken,
                        refreshToken = token.refreshToken,
                        accessExp = token.accessExp.toString(),
                        refreshExp = token.refreshExp.toString()
                    )
                }
            } else throw TokenExpiredException()
        }
        val accessToken = runBlocking { localDataSource.getAccessToken().first() }
        builder.addHeader("Authorization", "Bearer $accessToken")

        return chain.proceed(builder.build())
    }
}