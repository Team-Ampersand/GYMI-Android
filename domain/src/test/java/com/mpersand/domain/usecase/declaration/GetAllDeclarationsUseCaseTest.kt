package com.mpersand.domain.usecase.declaration

import com.mpersand.domain.model.declaration.response.DeclarationResponseModel
import com.mpersand.domain.model.declaration.util.DeclarationTypeModel
import com.mpersand.domain.repository.FakeDeclarationRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class GetAllDeclarationsUseCaseTest : BehaviorSpec() {
    private val repository = FakeDeclarationRepository(declarations)
    private val useCase = GetAllDeclarationsUseCase(repository = repository)

    init {
        Given("신고 내역 리스트가 존재한다") {
            val expected = declarations
            When("모든 신고 내역을 조회한다") {
                val declarations = useCase().getOrNull()
                Then("모든 신고 내역을 반환한다") {
                    declarations shouldBe expected
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