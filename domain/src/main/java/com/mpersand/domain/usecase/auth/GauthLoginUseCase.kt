package com.mpersand.domain.usecase.auth

import com.mpersand.domain.model.auth.request.GauthLoginRequestModel
import com.mpersand.domain.repository.AuthRepository
import javax.inject.Inject

class GauthLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(gAuthLoginRequestModel: GauthLoginRequestModel) = kotlin.runCatching { authRepository.gAuthLogin(gAuthLoginRequestModel) }
}