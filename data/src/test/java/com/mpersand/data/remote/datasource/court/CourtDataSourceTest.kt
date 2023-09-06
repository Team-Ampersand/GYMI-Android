package com.mpersand.data.remote.datasource.court

import com.mpersand.data.remote.model.court.response.CourtResponse
import com.mpersand.data.remote.model.util.CourtType
import com.mpersand.data.remote.model.util.DayOfWeekType
import com.mpersand.data.remote.model.util.SportType
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
                coEvery { courtApi.getCourtById(1) } returns allCourts.single { it.id == 1L }
                dataSource.getCourtById(1)
                Then("코트 id에 맞는 특정 코트가 반환된다") {
                    coVerify { dataSource.getCourtById(1) }
                }
            }
        }
    }

    companion object {
        private val allCourts = listOf(
            CourtResponse(
                id = 1,
                limit = 4,
                possibleDay = DayOfWeekType.MON,
                sportType = SportType.BASKETBALL,
                courtType = CourtType.HALF
            )
        )
    }
}