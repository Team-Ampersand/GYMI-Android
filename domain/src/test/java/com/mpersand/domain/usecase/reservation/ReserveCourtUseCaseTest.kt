package com.mpersand.domain.usecase.reservation

import com.mpersand.domain.model.reservation.request.CourtNumberModel
import com.mpersand.domain.repository.ReservationRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk

class ReserveCourtUseCaseTest: BehaviorSpec() {
    private val repository: ReservationRepository = mockk()
    private val useCase = ReserveCourtUseCase(repository = repository)

    init {
        Given("코트가 존재한다") {
            When("코트를 예약한다") {
                coEvery { repository.reserveCourt(CourtNumberModel.FIRST) } just Runs
                useCase(CourtNumberModel.FIRST)
                Then("코트가 예약된다") {
                    coVerify { useCase(CourtNumberModel.FIRST) }
                }
            }
        }
    }
}
