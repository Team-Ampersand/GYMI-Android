package com.mpersand.domain.usecase.reservation

import com.mpersand.domain.model.reservation.request.CourtNumberModel
import com.mpersand.domain.repository.ReservationRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk

class CancelReservationUseCaseTest: BehaviorSpec() {
    private val repository: ReservationRepository = mockk()
    private val useCase = CancelReservationUseCase(repository = repository)

    init {
        Given("코트가 존재한다") {
            When("코트 예약을 취소한다") {
                coEvery { repository.cancelReservation(CourtNumberModel.FIRST) } just Runs
                useCase(CourtNumberModel.FIRST)
                Then("코트 예약이 취소된다") {
                    coVerify { useCase(CourtNumberModel.FIRST) }
                }
            }
        }
    }
}
