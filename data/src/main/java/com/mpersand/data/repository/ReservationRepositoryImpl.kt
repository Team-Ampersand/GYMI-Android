package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.reservation.ReservationDataSource
import com.mpersand.data.remote.model.reservation.request.asCourtNumber
import com.mpersand.domain.model.reservation.request.CourtNumberModel
import com.mpersand.domain.repository.ReservationRepository
import javax.inject.Inject

class ReservationRepositoryImpl @Inject constructor(
    private val reservationDataSource: ReservationDataSource
): ReservationRepository {
    override suspend fun reserveCourt(courtNumber: CourtNumberModel) =
        reservationDataSource.reserveCourt(courtNumber.asCourtNumber())

    override suspend fun cancelReservation(courtNumber: CourtNumberModel) =
        reservationDataSource.cancelReservation(courtNumber.asCourtNumber())
}
