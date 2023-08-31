package com.mpersand.domain.usecase.declaration

import com.mpersand.domain.repository.DeclarationRepository
import javax.inject.Inject

class GetDeclarationByIdUseCase @Inject constructor(
    private val repository: DeclarationRepository
) {
    suspend operator fun invoke(id: Long) = kotlin.runCatching { repository.getDeclarationById(id) }
}