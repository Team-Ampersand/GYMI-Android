package com.mpersand.data.remote.model.auth.gAuthLogin.request

import com.mpersand.domain.model.auth.request.GauthLoginRequestData

data class GauthLoginRequest(
    val code: String,
    val token: String?
)

fun GauthLoginRequestData.asGauthLoginRequest() = GauthLoginRequest(
    code = code,
    token = token
)