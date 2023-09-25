package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.reservation.request.CourtNumber
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Query

interface ReservationApi {
    @POST("reservation")
    fun reserveCourt(
        @Query("courtNumber") courtNumber: CourtNumber
    )

    @DELETE("reservation")
    fun cancelReservation(
        @Query("courtNumber") courtNumber: CourtNumber
    )
}
