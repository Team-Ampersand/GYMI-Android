package com.mpersand.domain.usecase.notice

import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.mpersand.domain.model.notice.response.NoticeFileModel
import com.mpersand.domain.model.notice.response.NoticeResponseModel
import com.mpersand.domain.repository.FakeNoticeRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class GetAllNoticeUseCaseTest : BehaviorSpec() {
    private val repository = FakeNoticeRepository(noticeResponse, noticeDetailResponse)
    private val useCase = GetAllNoticeUseCase(noticeRepository = repository)

    init {
        Given("공지사항이 존재한다") {
            val expected = noticeResponse
            When("공지사항을 모두 가져온다") {
                val notice = useCase().getOrNull()
                Then("공지사항 리스트를 반환한다") {
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