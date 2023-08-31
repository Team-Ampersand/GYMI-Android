package com.mpersand.domain.usecase.declaration

import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.mpersand.domain.repository.DeclarationRepository
import javax.inject.Inject

class SubmitDeclarationUseCase @Inject constructor(
    private val repository: DeclarationRepository
) {
    suspend operator fun invoke(body: DeclarationRequestModel) = kotlin.runCatching { repository.submitDeclaration(body) }
}