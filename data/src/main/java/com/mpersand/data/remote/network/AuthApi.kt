package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.auth.gAuthLogin.request.GauthLoginRequest
import com.mpersand.data.remote.model.auth.gAuthLogin.response.GauthLoginResponse
import com.mpersand.data.remote.model.auth.tokenReissue.request.TokenReissueRequest
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthApi {
    @POST
    suspend fun gAuthLogin(gAuthLoginRequest: GauthLoginRequest): GauthLoginResponse

    @DELETE
    suspend fun gAuthLogout()

    @PATCH
    suspend fun tokenReissue(tokenReissueRequest: TokenReissueRequest): GauthLoginResponse
}