package com.mpersand.domain.usecase.court

import com.mpersand.domain.model.court.response.CourtResponseModel
import com.mpersand.domain.model.util.CourtTypeModel
import com.mpersand.domain.model.util.DayOfWeekTypeModel
import com.mpersand.domain.model.util.SportTypeModel
import com.mpersand.domain.repository.CourtRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk

class GetCourtByIdUseCaseTest : BehaviorSpec() {
    private val repository: CourtRepository = mockk()
    private val useCase = GetCourtByIdUseCase(repository = repository)

    init {
        Given("코트가 존재한다") {
            When("코트 id를 통해 특정 코트를 가져온다") {
                coEvery { repository.getCourtById(1) } returns allCourts.single { it.id == 1L }
                useCase(1)
                Then("코트 id에 맞는 특정 코트가 반환된다") {
                    coVerify { useCase(1) }
                }
            }
        }
    }

    companion object {
        private val allCourts = listOf(
            CourtResponseModel(
                id = 1,
                limit = 4,
                possibleDay = DayOfWeekTypeModel.MON,
                sportTypeModel = SportTypeModel.BASKETBALL,
                courtTypeModel = CourtTypeModel.HALF
            )
        )
    }
}