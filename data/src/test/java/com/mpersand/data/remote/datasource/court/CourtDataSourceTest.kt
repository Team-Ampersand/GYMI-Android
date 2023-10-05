package com.mpersand.data.remote.datasource.court

import com.mpersand.data.remote.model.court.response.CourtListResponse
import com.mpersand.data.remote.model.court.response.CourtResponse
import com.mpersand.data.remote.model.court.response.Reservations
import com.mpersand.data.remote.network.CourtApi
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk

class CourtDataSourceTest : BehaviorSpec() {
    private val courtApi: CourtApi = mockk()
    private val dataSource = CourtDataSourceImpl(courtApi = courtApi)

    init {
        Given("코트가 존재한다") {
            When("코트를 사용금지 한다") {
                coEvery { courtApi.banCourtById(1) } just Runs
                dataSource.banCourtById(1)
                Then("코드가 사용금지 된다") {
                    coVerify { dataSource.banCourtById(1) }
                }
            }

            When("모든 코트를 가져온다") {
                coEvery { courtApi.getAllCourts() } returns allCourts
                dataSource.getAllCourts()
                Then("모든 코트가 반환된다") {
                    coVerify { dataSource.getAllCourts() }
                }
            }

            When("코트 id를 통해 특정 코트를 가져온다") {
                coEvery { courtApi.getCourtById(1) } returns allCourts.courtList.single { it.id == 1L }
                dataSource.getCourtById(1)
                Then("코트 id에 맞는 특정 코트가 반환된다") {
                    coVerify { dataSource.getCourtById(1) }
                }
            }
        }
    }

    companion object {
        private val allCourts = CourtListResponse(
            listOf(
                CourtResponse(
                    id = 1,
                    name = "1번 코트",
                    count = 3,
                    maxCount = 8,
                    courtNumber = "FIRST",
                    week = "MONDAY",
                    dayPeriod = "LUNCH",
                    reservations = listOf(
                        Reservations(id = "test", nickname = "test", grade = 1, classNum = 1, number = 1)
                    ),
                    activity = "배드민턴"
                )
            )
        )
    }
}
