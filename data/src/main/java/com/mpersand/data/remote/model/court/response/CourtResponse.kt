package com.mpersand.data.remote.model.court.response

data class CourtResponse(
    val id: Long,
    val limit: Long,
    val possibleDay: DayOfWeekType,
    val sportType: SportType,
    val courtType: CourtType
)

enum class DayOfWeekType {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

enum class SportType {
    BASKETBALL, BADMINTON
}

enum class CourtType {
    HALF, FULL
}
