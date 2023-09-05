package com.mpersand.domain.usecase.declaration

import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.mpersand.domain.model.declaration.response.DeclarationResponseModel
import com.mpersand.domain.model.declaration.util.DeclarationTypeModel
import com.mpersand.domain.repository.FakeDeclarationRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class SubmitDeclarationUseCaseTest : BehaviorSpec() {
    private val repository = FakeDeclarationRepository(declarations)
    private val useCase = SubmitDeclarationUseCase(repository = repository)

    init {
        Given("신고 내역 리스트가 존재한다") {
            When("코트를 신고한다") {
                useCase(
                    courtId = 1,
                    body = DeclarationRequestModel(type = DeclarationTypeModel.TIME, content = null)
                )
                Then("신고 내역이 추가된다") {
                    repository.getAllDeclarations().size shouldBe 4
                }
            }
        }
    }

    companion object {
        private val declarations = listOf(
            DeclarationResponseModel(
                id = 1,
                type = DeclarationTypeModel.EQUIPMENT,
                content = ""
            ),
            DeclarationResponseModel(
                id = 2,
                type = DeclarationTypeModel.FOOD,
                content = ""
            ),
            DeclarationResponseModel(
                id = 3,
                type = DeclarationTypeModel.ETC,
                content = null
            )
        )
    }
}