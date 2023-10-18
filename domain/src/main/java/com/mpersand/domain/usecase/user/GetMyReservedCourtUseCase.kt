package com.mpersand.domain.usecase.user

import com.mpersand.domain.repository.UserRepository
import javax.inject.Inject

class GetMyReservedCourtUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { userRepository.getMyReservedCourt() }
}
