package com.mpersand.domain.usecase.court

import com.mpersand.domain.repository.CourtRepository
import javax.inject.Inject

class GetCourtByIdUseCase @Inject constructor(
    private val repository: CourtRepository
) {
    suspend operator fun invoke(courtId: Long) = kotlin.runCatching { repository.getCourtById(courtId) }
}