package com.mpersand.data.remote.network

import com.mpersand.data.remote.model.court.response.CourtResponse
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface CourtApi {
    @PATCH("court/ban/{courtId}")
    suspend fun banCourtById(
        @Path("courtId") courtId: Long
    )

    @GET("court")
    suspend fun getAllCourts(): List<CourtResponse>

    @GET("court/{courtId}")
    suspend fun getCourtById(
        @Path("courtId") courtId: Long
    ): CourtResponse
}