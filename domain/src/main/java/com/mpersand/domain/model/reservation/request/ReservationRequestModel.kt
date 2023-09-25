package com.mpersand.domain.model.reservation.request

data class ReservationRequestModel(
    val courtNumber: CourtNumberModel
)
enum class CourtNumberModel(value: String) {
    FIRST("1번코트"),
    SECOND("2번코트"),
    THREE("3번코트"),
    FOUR("4번코트")
}
