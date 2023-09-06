package com.mpersand.domain.usecase.notice

import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.mpersand.domain.model.notice.response.NoticeFileModel
import com.mpersand.domain.model.notice.response.NoticeResponseModel
import com.mpersand.domain.repository.FakeNoticeRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class GetDetailNoticeUseCaseTest : BehaviorSpec() {
    private val repository = FakeNoticeRepository(noticeResponse, noticeDetailResponse)
    private val useCase = GetDetailNoticeUsecase(noticeRepository = repository)

    init {
        Given("공지사항이 존재한다") {
            val expected = noticeDetailResponse
            When("원하는 공지사항 상세정보를 가져온다") {
                val notice = useCase(1).getOrNull()
                Then("원하는 공지사항 상세정보를 반환한다") {
                    notice shouldBe expected
                }
            }
        }
    }

    companion object {
        private val noticeResponse = listOf(
            NoticeResponseModel(
                id = 1,
                title = "title 1",
                content = "content 1",
                role = "",
                createdDate = LocalDateTime.now()
            )
        )


        private val noticeDetailResponse = NoticeDetailResponseModel(
            id = 1,
            title = "title 1",
            content = "content 1",
            role = "",
            noticeFile = listOf(
                NoticeFileModel(
                    id = 1,
                    url = ""
                )
            ),
            createdDate = LocalDateTime.now()
        )
    }
}