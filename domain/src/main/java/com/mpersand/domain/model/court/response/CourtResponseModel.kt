package com.mpersand.domain.model.court.response

data class CourtListResponseModel(
    val courtList: List<CourtResponseModel>
)

data class CourtResponseModel(
    val id: Long,
    val name: String,
    val count: Int,
    val maxCount: Int,
    val courtNumber: String,
    val week: String,
    val dayPeriod: String,
    val reservationUsers: List<ReservationsModel>,
    val activity: String
)

data class ReservationsModel(
    val id: String,
    val nickname: String,
    val grade: Int,
    val classNum: Int,
    val number: Int
)

