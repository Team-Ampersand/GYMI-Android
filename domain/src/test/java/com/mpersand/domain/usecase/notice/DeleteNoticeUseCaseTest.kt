package com.mpersand.domain.usecase.notice

import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.mpersand.domain.model.notice.response.NoticeFileModel
import com.mpersand.domain.model.notice.response.NoticeResponseModel
import com.mpersand.domain.repository.FakeNoticeRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class DeleteNoticeUseCaseTest : BehaviorSpec() {
    private val repository = FakeNoticeRepository(noticeResponse, noticeDetailResponse)
    private val useCase = DeleteNoticeUseCase(noticeRepository = repository)

    init {
        Given("공지사항이 존재한다") {
            When("공지사항을 삭제한다") {
                useCase(2)
                Then("공지사항이 삭제된다") {
                    repository.getAllNotice().size shouldBe 1
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
            ),
            NoticeResponseModel(
                id = 2,
                title = "title 2",
                content = "content 2",
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