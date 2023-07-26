package com.mpersand.data.remote.model.auth.gAuthLogin.request

data class GauthLoginRequest(
    val code: String,
    val token: String?
)
