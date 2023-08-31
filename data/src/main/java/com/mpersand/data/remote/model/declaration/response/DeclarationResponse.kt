package com.mpersand.data.remote.model.declaration.response

import com.mpersand.data.remote.model.declaration.util.DeclarationType
import com.mpersand.domain.model.declaration.response.DeclarationResponseModel
import com.mpersand.domain.model.declaration.util.DeclarationTypeModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeclarationResponse(
    val id: Long,
    val type: DeclarationType,
    val content: String?
)

fun DeclarationResponse.asDeclarationResponseModel() = DeclarationResponseModel(
    id = id,
    type = DeclarationTypeModel.valueOf(type.name),
    content = content
)