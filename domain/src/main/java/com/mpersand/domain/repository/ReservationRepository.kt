package com.mpersand.domain.repository

import com.mpersand.domain.model.reservation.request.CourtNumberModel

interface ReservationRepository {
    suspend fun reserveCourt(courtNumber: CourtNumberModel)

    suspend fun cancelReservation(courtNumber: CourtNumberModel)
}
