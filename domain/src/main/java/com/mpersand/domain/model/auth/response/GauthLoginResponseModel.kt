package com.mpersand.domain.model.auth.response

import java.time.ZonedDateTime

data class GauthLoginResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: String,
    val refreshExp: String
)
