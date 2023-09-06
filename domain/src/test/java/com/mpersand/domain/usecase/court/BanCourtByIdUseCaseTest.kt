package com.mpersand.domain.usecase.court

import com.mpersand.domain.repository.CourtRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk

class BanCourtByIdUseCaseTest : BehaviorSpec() {
    private val repository: CourtRepository = mockk()
    private val useCase = BanCourtByIdUseCase(repository = repository)

    init {
        Given("코트가 존재한다") {
            When("코트를 사용금지 한다") {
                coEvery { repository.banCourtById(1) } just Runs
                useCase(1)
                Then("코트가 사용중지 된다") {
                    coVerify { useCase(1) }
                }
            }
        }
    }
}