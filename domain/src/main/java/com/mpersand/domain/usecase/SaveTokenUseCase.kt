package com.mpersand.domain.usecase

import com.mpersand.domain.repository.AuthRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        accessToken: String,
        refreshToken: String,
        accessExp: String,
        refreshExp: String
    ) = authRepository.saveToken(
        accessToken = accessToken,
        refreshToken = refreshToken,
        accessExp = accessExp,
        refreshExp = refreshExp
    )
}