package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.auth.gAuthLogin.request.GauthLoginRequest
import com.mpersand.data.remote.model.auth.gAuthLogin.response.GauthLoginResponse
import com.mpersand.data.remote.model.auth.tokenReissue.request.TokenReissueRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthApi {
    @POST("auth")
    suspend fun gAuthLogin(
        @Body gAuthLoginRequest: GauthLoginRequest
    ): GauthLoginResponse

    @DELETE("auth")
    suspend fun gAuthLogout()

    @PATCH("auth")
    suspend fun tokenReissue(
        @Body tokenReissueRequest: TokenReissueRequest
    ): GauthLoginResponse
}