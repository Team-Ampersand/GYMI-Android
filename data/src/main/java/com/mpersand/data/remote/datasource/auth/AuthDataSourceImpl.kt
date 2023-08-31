package com.mpersand.data.remote.datasource.auth

import com.mpersand.data.remote.model.auth.request.GauthLoginRequest
import com.mpersand.data.remote.model.auth.response.GauthLoginResponse
import com.mpersand.data.remote.network.AuthApi
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi
): AuthDataSource {
    override suspend fun gAuthLogin(gAuthLoginRequest: GauthLoginRequest): GauthLoginResponse = authApi.gAuthLogin(gAuthLoginRequest)

    override suspend fun gAuthLogout() = authApi.gAuthLogout()
}