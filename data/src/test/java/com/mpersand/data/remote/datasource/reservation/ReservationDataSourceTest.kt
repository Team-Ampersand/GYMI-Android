package com.mpersand.data.remote.datasource.reservation

import com.mpersand.data.remote.model.reservation.request.CourtNumber
import com.mpersand.data.remote.network.ReservationApi
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk

class ReservationDataSourceTest: BehaviorSpec() {
    private val reservationApi: ReservationApi = mockk()
    private val dataSource = ReservationDataSourceImpl(reservationApi = reservationApi)

    init {
        Given("코트가 존재한다") {
            When("코트를 예약한다") {
                coEvery { reservationApi.reserveCourt(CourtNumber.FIRST) } just Runs
                dataSource.reserveCourt(CourtNumber.FIRST)
                Then("코트가 예약된다") {
                    coVerify { dataSource.reserveCourt(CourtNumber.FIRST) }
                }
            }
            When("코트 예약을 취소한다") {
                coEvery { reservationApi.cancelReservation(CourtNumber.FIRST) } just Runs
                dataSource.cancelReservation(CourtNumber.FIRST)
                Then("코트 예약이 취소된다") {
                    coVerify { dataSource.cancelReservation(CourtNumber.FIRST) }
                }
            }
        }
    }
}
