package com.mpersand.domain.repository

import com.mpersand.domain.model.auth.request.GauthLoginRequestModel
import com.mpersand.domain.model.auth.response.GauthLoginResponseModel

interface AuthRepository {
    suspend fun gAuthLogin(gAuthLoginRequestModel: GauthLoginRequestModel): GauthLoginResponseModel

    suspend fun gAuthLogout()
}