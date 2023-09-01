package com.mpersand.presentation.util

import java.time.DayOfWeek
import java.time.LocalDateTime

fun getDayOfWeekType(): DayOfWeekType? = when (LocalDateTime.now().dayOfWeek) {
    DayOfWeek.MONDAY -> DayOfWeekType.MON
    DayOfWeek.TUESDAY -> DayOfWeekType.TUE
    DayOfWeek.WEDNESDAY -> DayOfWeekType.WEN
    DayOfWeek.THURSDAY -> DayOfWeekType.THU
    DayOfWeek.FRIDAY -> DayOfWeekType.FRI
    DayOfWeek.SATURDAY -> DayOfWeekType.SAT
    DayOfWeek.SUNDAY -> DayOfWeekType.SUN
    else -> null
}