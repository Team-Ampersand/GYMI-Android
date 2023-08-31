package com.mpersand.data.repository

import com.mpersand.data.remote.model.declaration.response.DeclarationResponse
import com.mpersand.data.remote.model.declaration.response.asDeclarationResponseModel
import com.mpersand.data.remote.model.declaration.util.DeclarationType
import com.mpersand.domain.model.declaration.request.DeclarationRequestModel
import com.mpersand.domain.model.declaration.util.DeclarationTypeModel
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class DeclarationRepositoryTest : BehaviorSpec() {
    private val repository = DeclarationRepositoryImpl(
        declarationDataSource = FakeDeclarationDataSource(declarations)
    )
    init {
        Given("신고 내역 리스트가 존재한다") {
            val expected = declarations.map { it.asDeclarationResponseModel() }
            When("모든 신고 내역을 조회한다") {
                val declarations = repository.getAllDeclarations()
                Then("모든 신고 내역을 반환한다") {
                    declarations shouldBe expected
                }
            }

            When("단일 신고 내역을 조회한다") {
                val declaration = repository.getDeclarationById(1)
                Then("단일 신고 내역을 반환한다") {
                    declaration shouldBe expected.single { it.id == 1L }
                }
            }

            When("코트를 신고한다") {
                repository.submitDeclaration(
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
            DeclarationResponse(
                id = 1,
                type = DeclarationType.EQUIPMENT,
                content = ""
            ),
            DeclarationResponse(
                id = 2,
                type = DeclarationType.FOOD,
                content = ""
            ),
            DeclarationResponse(
                id = 3,
                type = DeclarationType.ETC,
                content = null
            )
        )
    }
}