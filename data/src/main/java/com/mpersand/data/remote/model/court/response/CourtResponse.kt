package com.mpersand.data.remote.model.court.response

import com.mpersand.domain.model.court.response.CourtResponseModel
import com.mpersand.domain.model.court.response.ReservationUserModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourtResponse(
    val id: Long,
    val name: String,
    val count: Int,
    val maxCount: Int,
    val courtNumber: String,
    val week: String,
    val dayPeriod: String,
    val reservationUsers: List<ReservationUser>
)

@JsonClass(generateAdapter = true)
data class ReservationUser(
    val id: String,
    val name: String,
    val classNum: String
)

fun CourtResponse.asCourtResponseModel() = CourtResponseModel(
    id = id,
    name = name,
    count = count,
    maxCount = maxCount,
    courtNumber = courtNumber,
    week = week,
    dayPeriod = dayPeriod,
    reservationUsers = reservationUsers.map { it.asReservationUserModel() }
)

fun ReservationUser.asReservationUserModel() = ReservationUserModel(
    id = id,
    name = name,
    classNum = classNum
)
