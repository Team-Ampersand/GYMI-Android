package com.mpersand.domain.repository

import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.mpersand.domain.model.declaration.response.DeclarationResponseModel

interface DeclarationRepository {
    suspend fun getAllDeclarations(): List<DeclarationResponseModel>

    suspend fun getDeclarationById(id: Long): DeclarationResponseModel

    suspend fun submitDeclaration(body: DeclarationRequestModel)
}