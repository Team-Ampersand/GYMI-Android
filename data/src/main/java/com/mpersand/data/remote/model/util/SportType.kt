package com.mpersand.data.remote.model.util

import com.mpersand.domain.model.util.SportTypeModel

enum class SportType {
    BASKETBALL, BADMINTON
}

fun SportType.asSportTypeModel() = when (this) {
    SportType.BASKETBALL -> SportTypeModel.BASKETBALL
    SportType.BADMINTON -> SportTypeModel.BADMINTON
}