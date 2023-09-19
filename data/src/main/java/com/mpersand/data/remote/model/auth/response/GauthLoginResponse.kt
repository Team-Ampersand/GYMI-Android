package com.mpersand.data.remote.model.auth.response

import com.mpersand.domain.model.auth.response.GauthLoginResponseModel
import com.squareup.moshi.JsonClass
import java.time.ZonedDateTime

@JsonClass(generateAdapter = true)
data class GauthLoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: String,
    val refreshExp: String
)

fun GauthLoginResponse.asGauthLoginResponseModel() = GauthLoginResponseModel(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessExp = accessExp,
    refreshExp = refreshExp
)
