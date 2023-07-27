package com.mpersand.data.remote.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.mpersand.data.BuildConfig
import com.mpersand.data.local.datasource.LocalDataSource
import com.mpersand.domain.exception.TokenExpiredException
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
    private val localDataSource: LocalDataSource
) : Interceptor {
    @RequiresApi(Build.VERSION_CODES.O)
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
                val token = JsonParser.parseString(response.body!!.string()) as JsonObject
                runBlocking {
                    localDataSource.saveToken(
                        accessToken = token["accessToken"].asString,
                        refreshToken = token["refreshToken"].asString,
                        accessExp = token["accessExp"].asString,
                        refreshExp = token["refreshExp"].asString
                    )
                }
            } else  throw TokenExpiredException()
        }
        val accessToken = runBlocking { localDataSource.getAccessToken().first() }
        builder.addHeader("Authorization", "Bearer $accessToken")

        return chain.proceed(builder.build())
    }
}