package com.mpersand.domain.model.auth.request

data class GauthLoginRequestData(
    val code: String,
    val token: String?
)
