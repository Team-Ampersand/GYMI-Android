package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.AuthDataSource
import com.mpersand.data.remote.model.auth.gAuthLogin.request.asGauthLoginRequest
import com.mpersand.data.remote.model.auth.gAuthLogin.response.asGauthLoginResponseModel
import com.mpersand.domain.model.auth.request.GauthLoginRequestModel
import com.mpersand.domain.model.auth.response.GauthLoginResponseModel
import com.mpersand.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
): AuthRepository {
    override suspend fun gAuthLogin(gAuthLoginRequestModel: GauthLoginRequestModel): GauthLoginResponseModel =
        authDataSource.gAuthLogin(gAuthLoginRequestModel.asGauthLoginRequest()).asGauthLoginResponseModel()

    override suspend fun gAuthLogout() = authDataSource.gAuthLogout()
}