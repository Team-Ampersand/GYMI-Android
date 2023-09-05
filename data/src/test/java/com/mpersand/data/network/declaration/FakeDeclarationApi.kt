package com.mpersand.data.network.declaration

import com.mpersand.data.remote.model.declaration.request.DeclarationRequest
import com.mpersand.data.remote.model.declaration.response.DeclarationResponse
import com.mpersand.data.remote.network.DeclarationApi

class FakeDeclarationApi(private var declarations: List<DeclarationResponse>) : DeclarationApi {
    override suspend fun getAllDeclarations(): List<DeclarationResponse> = declarations

    override suspend fun getDeclarationById(id: Long): DeclarationResponse = declarations.single { it.id == id }

    override suspend fun submitDeclaration(courtId: Long, body: DeclarationRequest) {
        declarations = declarations.plus(
            DeclarationResponse(id = courtId, type = body.type, content = body.content)
        )
    }
}