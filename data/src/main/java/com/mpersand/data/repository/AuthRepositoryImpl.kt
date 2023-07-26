package com.mpersand.data.repository

import com.mpersand.data.local.datasource.LocalDataSource
import com.mpersand.data.remote.datasource.AuthDataSource
import com.mpersand.data.remote.model.auth.gAuthLogin.request.asGauthLoginRequest
import com.mpersand.data.remote.model.auth.gAuthLogin.response.asGauthLoginResponseModel
import com.mpersand.domain.model.auth.request.GauthLoginRequestModel
import com.mpersand.domain.model.auth.response.GauthLoginResponseModel
import com.mpersand.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val localDataSource: LocalDataSource
): AuthRepository {
    override suspend fun gAuthLogin(gAuthLoginRequestModel: GauthLoginRequestModel): GauthLoginResponseModel =
        authDataSource.gAuthLogin(gAuthLoginRequestModel.asGauthLoginRequest()).asGauthLoginResponseModel()

    override suspend fun gAuthLogout() = authDataSource.gAuthLogout()
    override suspend fun saveToken(accessToken: String, refreshToken: String, accessExp: String, refreshExp: String) {
        localDataSource.saveToken(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessExp = accessExp,
            refreshExp = refreshExp
        )
    }
}