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

class GetAllCourtsUseCaseTest : BehaviorSpec() {
    private val repository: CourtRepository = mockk()
    private val useCase = GetAllCourtsUseCase(repository = repository)

    init {
        Given("코트가 존재한다") {
            When("모든 코트를 가져온다") {
                coEvery { repository.getAllCourts() } returns allCourts
                useCase()
                Then("모든 코트가 반환된다") {
                    coVerify { useCase() }
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