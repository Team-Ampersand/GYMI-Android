package com.mpersand.data.remote.datasource.reservation

import com.mpersand.data.remote.model.reservation.request.CourtNumber
import com.mpersand.data.remote.network.ReservationApi
import javax.inject.Inject

class ReservationDataSourceImpl @Inject constructor(
    private val reservationApi: ReservationApi
): ReservationDataSource {
    override suspend fun reserveCourt(courtNumber: CourtNumber) = reservationApi.reserveCourt(courtNumber)

    override suspend fun cancelReservation(courtNumber: CourtNumber) = reservationApi.cancelReservation(courtNumber)
}
