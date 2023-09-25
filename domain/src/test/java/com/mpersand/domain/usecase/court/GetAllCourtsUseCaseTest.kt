package com.mpersand.domain.usecase.court

import com.mpersand.domain.model.court.response.CourtResponseModel
import com.mpersand.domain.model.court.response.ReservationUserModel
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
                name = "1번 코트",
                count = 3,
                maxCount = 8,
                courtNumber = "FIRST",
                week = "MONDAY",
                dayPeriod = "LUNCH",
                reservationUsers = listOf(
                    ReservationUserModel("1", "박성현", "3208"),
                    ReservationUserModel("2", "조현서", "3117")
                )
            )
        )
    }
}
