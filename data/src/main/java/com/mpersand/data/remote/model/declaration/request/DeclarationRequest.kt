package com.mpersand.data.remote.model.declaration.request

import com.mpersand.data.remote.model.declaration.util.DeclarationType
import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeclarationRequest(
    val type: DeclarationType,
    val content: String?
)

fun DeclarationRequestModel.asDeclarationRequest() = DeclarationRequest(
    type = DeclarationType.valueOf(type.name),
    content = content
)