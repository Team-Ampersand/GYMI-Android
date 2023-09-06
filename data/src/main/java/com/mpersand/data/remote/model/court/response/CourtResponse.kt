package com.mpersand.data.remote.model.court.response

import com.mpersand.data.remote.model.util.CourtType
import com.mpersand.data.remote.model.util.DayOfWeekType
import com.mpersand.data.remote.model.util.SportType
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourtResponse(
    val id: Long,
    val limit: Long,
    val possibleDay: DayOfWeekType,
    val sportType: SportType,
    val courtType: CourtType
)