package com.mpersand.domain.usecase.declaration

import com.mpersand.domain.repository.DeclarationRepository
import javax.inject.Inject

class GetAllDeclarationsUseCase @Inject constructor(
    private val repository: DeclarationRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { repository.getAllDeclarations() }
}