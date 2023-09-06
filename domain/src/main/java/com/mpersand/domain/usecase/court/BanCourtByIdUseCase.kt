package com.mpersand.domain.usecase.court

import com.mpersand.domain.repository.CourtRepository
import javax.inject.Inject

class BanCourtByIdUseCase @Inject constructor(
    private val repository: CourtRepository
) {
    suspend operator fun invoke(courtId: Long) = kotlin.runCatching { repository.banCourtById(courtId) }
}