package com.mpersand.domain.repository

import com.mpersand.domain.model.court.response.CourtListResponseModel
import com.mpersand.domain.model.court.response.CourtResponseModel

interface CourtRepository {
    suspend fun banCourtById(courtId: Long)

    suspend fun getAllCourts(): CourtListResponseModel

    suspend fun getCourtById(courtId: Long): CourtResponseModel
}
