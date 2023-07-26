package com.mpersand.domain.usecase

import com.mpersand.domain.model.auth.request.GauthLoginRequestData
import com.mpersand.domain.repository.AuthRepository
import javax.inject.Inject

class GauthLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(gAuthLoginRequestData: GauthLoginRequestData) = kotlin.runCatching { authRepository.gAuthLogin(gAuthLoginRequestData) }
}