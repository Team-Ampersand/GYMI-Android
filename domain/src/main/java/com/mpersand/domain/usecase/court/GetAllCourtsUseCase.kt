package com.mpersand.domain.usecase.court

import com.mpersand.domain.repository.CourtRepository
import javax.inject.Inject

class GetAllCourtsUseCase @Inject constructor(
    private val repository: CourtRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { repository.getAllCourts() }
}