package com.mpersand.data.remote.model.court.response

import com.mpersand.domain.model.court.response.CourtListResponseModel
import com.mpersand.domain.model.court.response.CourtResponseModel
import com.mpersand.domain.model.court.response.ReservationsModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourtListResponse(
    val courtList: List<CourtResponse>
)

@JsonClass(generateAdapter = true)
data class CourtResponse(
    val id: Long,
    val name: String,
    val count: Int,
    val maxCount: Int,
    val courtNumber: String,
    val week: String,
    val dayPeriod: String,
    val reservations: List<Reservations>,
    val activity: String
)

@JsonClass(generateAdapter = true)
data class Reservations(
    val id: String,
    val nickname: String,
    val grade: Int,
    val classNum: Int,
    val number: Int
)

fun CourtListResponse.asCourtListResponseModel() = CourtListResponseModel(
    courtList = courtList.map { it.asCourtResponseModel() }
)

fun CourtResponse.asCourtResponseModel() = CourtResponseModel(
    id = id,
    name = name,
    count = count,
    maxCount = maxCount,
    courtNumber = courtNumber,
    week = week,
    dayPeriod = dayPeriod,
    reservationUsers = reservations.map { it.asReservations() },
    activity = activity
)

fun Reservations.asReservations() = ReservationsModel(
    id = id,
    nickname = nickname,
    grade = grade,
    classNum = classNum,
    number = number
)
