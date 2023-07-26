package com.mpersand.data.remote.model.auth.gAuthLogin.response

import java.time.ZonedDateTime

data class GauthLoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: ZonedDateTime,
    val refreshExp: ZonedDateTime
)
