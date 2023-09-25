package com.mpersand.domain.usecase.court

import com.mpersand.domain.model.court.response.CourtResponseModel
import com.mpersand.domain.model.court.response.ReservationUserModel
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
