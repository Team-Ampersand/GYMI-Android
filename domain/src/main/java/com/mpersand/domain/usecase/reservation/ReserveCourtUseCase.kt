package com.mpersand.domain.usecase.reservation

import com.mpersand.domain.model.reservation.request.CourtNumberModel
import com.mpersand.domain.repository.ReservationRepository
import javax.inject.Inject

class ReserveCourtUseCase @Inject constructor(
    private val repository: ReservationRepository
) {
    suspend operator fun invoke(courtNumberModel: CourtNumberModel) =
        kotlin.runCatching { repository.reserveCourt(courtNumberModel) }
}
