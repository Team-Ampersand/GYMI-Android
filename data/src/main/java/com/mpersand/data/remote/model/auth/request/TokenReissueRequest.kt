package com.mpersand.data.remote.model.auth.request

import com.squareup.moshi.JsonClass
import java.time.ZonedDateTime

@JsonClass(generateAdapter = true)
data class TokenReissueRequest(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: String,
    val refreshExp: String
)
