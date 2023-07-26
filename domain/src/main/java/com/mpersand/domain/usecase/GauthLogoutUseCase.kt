package com.mpersand.domain.usecase

import com.mpersand.domain.repository.AuthRepository
import javax.inject.Inject

class GauthLogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { authRepository.gAuthLogout() }
}