package com.mpersand.data.remote.model.reservation.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReservationRequest(
    val courtNumber: CourtNumber
)
enum class CourtNumber(value: String) {
    FIRST("1번코트"),
    SECOND("2번코트"),
    THREE("3번코트"),
    FOUR("4번코트")
}
