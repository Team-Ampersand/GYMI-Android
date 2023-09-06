package com.mpersand.domain.usecase.notice

import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.mpersand.domain.model.notice.response.NoticeFileModel
import com.mpersand.domain.model.notice.response.NoticeResponseModel
import com.mpersand.domain.repository.FakeNoticeRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.time.LocalDateTime

class CreateNoticeUseCaseTest : BehaviorSpec() {
    private val repository = FakeNoticeRepository(noticeResponse, noticeDetailResponse)
    private val useCase = CreateNoticeUseCase(noticeRepository = repository)

    init {
        Given("공지사항이 존재한다") {
            When("공지사항을 작성한다") {
                noticeMap["title"] = "title".toRequestBody("text/plain".toMediaType())
                noticeMap["content"] = "content".toRequestBody("text/plain".toMediaType())
                useCase(
                    notice = noticeMap,
                    file = filePart
                )
                Then("공지사항이 생성된다") {
                    repository.getAllNotice().size shouldBe 2
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

        private var noticeMap = HashMap<String, RequestBody>()

        private val file = File("")
        private val filePart = MultipartBody.Part.createFormData(
            "file",
            file.name,
            file.asRequestBody("multipart/form-data".toMediaType())
        )
    }
}