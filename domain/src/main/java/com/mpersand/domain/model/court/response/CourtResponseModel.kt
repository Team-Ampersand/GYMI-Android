package com.mpersand.domain.model.court.response

import com.mpersand.domain.model.util.CourtTypeModel
import com.mpersand.domain.model.util.DayOfWeekTypeModel
import com.mpersand.domain.model.util.SportTypeModel

data class CourtResponseModel(
    val id: Long,
    val limit: Long,
    val possibleDay: DayOfWeekTypeModel,
    val sportTypeModel: SportTypeModel,
    val courtTypeModel: CourtTypeModel
)
