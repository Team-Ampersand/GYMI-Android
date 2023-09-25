package com.mpersand.data.remote.datasource.reservation

import com.mpersand.data.remote.model.reservation.request.CourtNumber

interface ReservationDataSource {
    suspend fun reserveCourt(courtNumber: CourtNumber)

    suspend fun cancelReservation(courtNumber: CourtNumber)
}
