package com.mpersand.data.remote.model.court.response

import com.mpersand.data.remote.model.util.CourtType
import com.mpersand.data.remote.model.util.DayOfWeekType
import com.mpersand.data.remote.model.util.SportType
import com.mpersand.data.remote.model.util.asCourtTypeModel
import com.mpersand.data.remote.model.util.asDayOfWeekTypeModel
import com.mpersand.data.remote.model.util.asSportTypeModel
import com.mpersand.domain.model.court.response.CourtResponseModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourtResponse(
    val id: Long,
    val limit: Long,
    val possibleDay: DayOfWeekType,
    val sportType: SportType,
    val courtType: CourtType
)

fun CourtResponse.asCourtResponseModel() = CourtResponseModel(
    id = id,
    limit = limit,
    possibleDay = possibleDay.asDayOfWeekTypeModel(),
    sportTypeModel = sportType.asSportTypeModel(),
    courtTypeModel = courtType.asCourtTypeModel()
)