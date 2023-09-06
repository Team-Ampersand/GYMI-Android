package com.mpersand.data.remote.datasource.court

import com.mpersand.data.remote.model.court.response.CourtResponse
import com.mpersand.data.remote.network.CourtApi
import javax.inject.Inject

class CourtDataSourceImpl @Inject constructor(
    private val courtApi: CourtApi
): CourtDataSource {
    override suspend fun banCourtById(courtId: Long) = courtApi.banCourtById(courtId)

    override suspend fun getAllCourts(): List<CourtResponse> = courtApi.getAllCourts()

    override suspend fun getCourtById(courtId: Long): CourtResponse = courtApi.getCourtById(courtId)
}