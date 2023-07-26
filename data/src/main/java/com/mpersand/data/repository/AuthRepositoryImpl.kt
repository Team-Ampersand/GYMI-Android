package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.AuthDataSource
import com.mpersand.data.remote.model.auth.gAuthLogin.request.asGauthLoginRequest
import com.mpersand.data.remote.model.auth.gAuthLogin.response.asGauthLoginResponseData
import com.mpersand.domain.model.auth.request.GauthLoginRequestData
import com.mpersand.domain.model.auth.response.GauthLoginResponseData
import com.mpersand.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
): AuthRepository {
    override suspend fun gAuthLogin(gAuthLoginRequestData: GauthLoginRequestData): GauthLoginResponseData =
        authDataSource.gAuthLogin(gAuthLoginRequestData.asGauthLoginRequest()).asGauthLoginResponseData()

    override suspend fun gAuthLogout() = authDataSource.gAuthLogout()
}