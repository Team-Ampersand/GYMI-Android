package com.mpersand.domain.repository

import com.mpersand.domain.model.court.response.CourtResponseModel

interface CourtRepository {
    suspend fun banCourtById(courtId: Long)

    suspend fun getAllCourts(): List<CourtResponseModel>

    suspend fun getCourtById(courtId: Long): CourtResponseModel
}