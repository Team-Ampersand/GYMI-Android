package com.mpersand.domain.repository

import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.mpersand.domain.model.declaration.response.DeclarationResponseModel

class FakeDeclarationRepository(private var declarations: List<DeclarationResponseModel>): DeclarationRepository {
    override suspend fun getAllDeclarations(): List<DeclarationResponseModel> = declarations

    override suspend fun getDeclarationById(id: Long): DeclarationResponseModel = declarations.single { it.id == id }

    override suspend fun submitDeclaration(body: DeclarationRequestModel) {
        declarations = declarations.plus(
            DeclarationResponseModel(id = declarations.size.toLong(), type = body.type, content = body.content)
        )
    }
}