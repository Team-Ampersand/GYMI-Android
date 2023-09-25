package com.mpersand.data.remote.model.reservation.request

import com.mpersand.domain.model.reservation.request.CourtNumberModel
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

fun CourtNumberModel.asCourtNumber() = when (this) {
    CourtNumberModel.FIRST -> CourtNumber.FIRST
    CourtNumberModel.SECOND -> CourtNumber.SECOND
    CourtNumberModel.THREE -> CourtNumber.THREE
    CourtNumberModel.FOUR -> CourtNumber.FOUR
}
