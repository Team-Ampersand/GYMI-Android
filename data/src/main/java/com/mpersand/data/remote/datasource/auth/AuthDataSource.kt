package com.mpersand.data.remote.datasource.auth

import com.mpersand.data.remote.model.auth.request.GauthLoginRequest
import com.mpersand.data.remote.model.auth.response.GauthLoginResponse

interface AuthDataSource {
    suspend fun gAuthLogin(gAuthLoginRequest: GauthLoginRequest): GauthLoginResponse

    suspend fun gAuthLogout()
}