package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.declaration.DeclarationDataSource
import com.mpersand.data.remote.model.declaration.request.asDeclarationRequest
import com.mpersand.data.remote.model.declaration.response.asDeclarationResponseModel
import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.mpersand.domain.model.declaration.response.DeclarationResponseModel
import com.mpersand.domain.repository.DeclarationRepository
import javax.inject.Inject

class DeclarationRepositoryImpl @Inject constructor(
    private val declarationDataSource: DeclarationDataSource
) : DeclarationRepository {
    override suspend fun getAllDeclarations(): List<DeclarationResponseModel> =
        declarationDataSource.getAllDeclarations().map { it.asDeclarationResponseModel() }

    override suspend fun getDeclarationById(id: Long): DeclarationResponseModel =
        declarationDataSource.getDeclarationById(id).asDeclarationResponseModel()

    override suspend fun submitDeclaration(courtId: Long, body: DeclarationRequestModel) =
        declarationDataSource.submitDeclaration(courtId, body.asDeclarationRequest())
}