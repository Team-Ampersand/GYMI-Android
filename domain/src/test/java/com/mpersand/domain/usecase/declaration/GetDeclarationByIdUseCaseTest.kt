package com.mpersand.domain.usecase.declaration

import com.mpersand.domain.model.declaration.response.DeclarationResponseModel
import com.mpersand.domain.model.declaration.util.DeclarationTypeModel
import com.mpersand.domain.repository.FakeDeclarationRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class GetDeclarationByIdUseCaseTest : BehaviorSpec() {
    private val repository = FakeDeclarationRepository(declarations)
    private val useCase = GetDeclarationByIdUseCase(repository = repository)
    init {
        Given("신고 내역 리스트가 존재한다") {
            val expected = declarations
            When("단일 신고 내역을 조회한다") {
                val declaration = useCase(1).getOrNull()
                Then("단일 신고 내역을 반환한다") {
                    declaration shouldBe expected.single { it.id == 1L }
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