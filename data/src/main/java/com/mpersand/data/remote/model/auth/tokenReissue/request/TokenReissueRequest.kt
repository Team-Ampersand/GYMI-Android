package com.mpersand.data.remote.model.auth.tokenReissue.request

import com.squareup.moshi.JsonClass
import java.time.ZonedDateTime

@JsonClass(generateAdapter = true)
data class TokenReissueRequest(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: ZonedDateTime,
    val refreshExp: ZonedDateTime
)
