package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.court.CourtDataSource
import com.mpersand.data.remote.model.court.response.asCourtListResponseModel
import com.mpersand.data.remote.model.court.response.asCourtResponseModel
import com.mpersand.domain.model.court.response.CourtListResponseModel
import com.mpersand.domain.model.court.response.CourtResponseModel
import com.mpersand.domain.repository.CourtRepository
import javax.inject.Inject

class CourtRepositoryImpl @Inject constructor(
    private val courtDataSource: CourtDataSource
) : CourtRepository {
    override suspend fun banCourtById(courtId: Long) = courtDataSource.banCourtById(courtId)

    override suspend fun getAllCourts(): CourtListResponseModel =
        courtDataSource.getAllCourts().asCourtListResponseModel()

    override suspend fun getCourtById(courtId: Long): CourtResponseModel =
        courtDataSource.getCourtById(courtId).asCourtResponseModel()
}
