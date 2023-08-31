package com.mpersand.data.remote.model.declaration.util

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
enum class DeclarationType {
    TIME, EQUIPMENT, SEAT, UNIFORM, FOOD, Dissension, ETC
}