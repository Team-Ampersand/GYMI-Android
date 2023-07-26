package com.mpersand.data.remote.datasource

import com.mpersand.data.remote.model.auth.gAuthLogin.request.GauthLoginRequest
import com.mpersand.data.remote.model.auth.gAuthLogin.response.GauthLoginResponse

interface AuthDataSource {
    suspend fun gAuthLogin(gAuthLoginRequest: GauthLoginRequest): GauthLoginResponse

    suspend fun gAuthLogout()
}