package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.auth.gAuthLogin.request.GauthLoginRequest
import com.mpersand.data.remote.model.auth.gAuthLogin.response.GauthLoginResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface AuthApi {
    @POST("auth")
    suspend fun gAuthLogin(
        @Body gAuthLoginRequest: GauthLoginRequest
    ): GauthLoginResponse

    @DELETE("auth")
    suspend fun gAuthLogout()
}