package com.mpersand.data.remote.model.util

import com.mpersand.domain.model.util.CourtTypeModel

enum class CourtType {
    HALF, FULL
}

fun CourtType.asCourtTypeModel() = when (this) {
    CourtType.HALF -> CourtTypeModel.HALF
    CourtType.FULL -> CourtTypeModel.FULL
}