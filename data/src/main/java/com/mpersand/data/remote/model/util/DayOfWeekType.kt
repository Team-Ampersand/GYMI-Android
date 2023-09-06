package com.mpersand.data.remote.model.util

import com.mpersand.domain.model.util.DayOfWeekTypeModel

enum class DayOfWeekType {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

fun DayOfWeekType.asDayOfWeekTypeModel() = when (this) {
    DayOfWeekType.MON -> DayOfWeekTypeModel.MON
    DayOfWeekType.TUE -> DayOfWeekTypeModel.TUE
    DayOfWeekType.WED -> DayOfWeekTypeModel.WED
    DayOfWeekType.THU -> DayOfWeekTypeModel.THU
    DayOfWeekType.FRI -> DayOfWeekTypeModel.FRI
    DayOfWeekType.SAT -> DayOfWeekTypeModel.SAT
    DayOfWeekType.SUN -> DayOfWeekTypeModel.SUN
}