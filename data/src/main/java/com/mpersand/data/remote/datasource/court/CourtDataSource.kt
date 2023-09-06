package com.mpersand.data.remote.datasource.court

import com.mpersand.data.remote.model.court.response.CourtResponse

interface CourtDataSource {
    suspend fun banCourtById(courtId: Long)

    suspend fun getAllCourts(): List<CourtResponse>

    suspend fun getCourtById(courtId: Long): CourtResponse
}