package com.mpersand.domain.repository

import com.mpersand.domain.model.auth.request.GauthLoginRequestData
import com.mpersand.domain.model.auth.response.GauthLoginResponseData

interface AuthRepository {
    suspend fun gAuthLogin(gAuthLoginRequestData: GauthLoginRequestData): GauthLoginResponseData

    suspend fun gAuthLogout()
}