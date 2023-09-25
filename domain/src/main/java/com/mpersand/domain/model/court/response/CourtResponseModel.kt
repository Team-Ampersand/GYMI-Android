package com.mpersand.domain.model.court.response

data class CourtResponseModel(
    val id: Long,
    val name: String,
    val count: Int,
    val maxCount: Int,
    val courtNumber: String,
    val week: String,
    val dayPeriod: String,
    val reservationUsers: List<ReservationUserModel>
)

data class ReservationUserModel(
    val id: String,
    val name: String,
    val classNum: String
)

