package com.mpersand.domain.model.auth.response

import java.time.ZonedDateTime

data class GauthLoginResponseData(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: ZonedDateTime,
    val refreshExp: ZonedDateTime
)
