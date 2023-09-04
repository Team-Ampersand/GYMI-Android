package com.mpersand.data.remote.datasource.notice

import com.mpersand.data.network.notice.FakeNoticeApi
import com.mpersand.data.remote.model.notice.response.NoticeDetailResponse
import com.mpersand.data.remote.model.notice.response.NoticeFile
import com.mpersand.data.remote.model.notice.response.NoticeList
import com.mpersand.data.remote.model.notice.response.NoticeResponse
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.time.LocalDateTime

class NoticeDataSourceTest : BehaviorSpec() {
    private val dataSource = NoticeDataSourceImpl(
        noticeApi = FakeNoticeApi(
            noticesResponses = noticeResponse,
            noticeDetailResponse = noticeDetailResponse,
            noticeDetailResponses = mutableListOf(noticeDetailResponse)
        )
    )

    init {
        Given("공지사항이 존재한다") {
            val allNotices = dataSource.getAllNotice()
            When("공지사항을 작성한다") {
                noticeMap["title"] = "title".toRequestBody("text/plain".toMediaType())
                noticeMap["content"] = "content".toRequestBody("text/plain".toMediaType())
                dataSource.createNotice(
                    notice = noticeMap,
                    file = filePart
                )
                Then("공지사항이 생성된다") {
                    dataSource.getAllNotice().body.size shouldBe 2
                }
            }

            When("공지사항을 삭제한다") {
                dataSource.deleteNotice(1)
                Then("공지사항이 삭제된다") {
                    dataSource.getAllNotice().body.size shouldBe 1
                }
            }

            When("공지사항을 수정한다") {
                val modifiedTitle = "modified title"
                noticeMap["title"] = "modified title".toRequestBody("text/plain".toMediaType())
                dataSource.modifyNotice(
                    id = 1,
                    notice = noticeMap,
                    file = filePart
                )
                Then("공지사항이 수정된다") {
                    val modifiedNotice = dataSource.getDetailNotice(1)
                    modifiedNotice.title shouldBe modifiedTitle
                }
            }

            When("공지사항을 모두 가져온다") {
                val notices = dataSource.getAllNotice()
                Then("공지사항 리스트를 반환한다") {
                    notices shouldBe allNotices
                }
            }

            When("원하는 공지사항 상세정보를 가져온다") {
                val notice = dataSource.getDetailNotice(1)
                Then("원하는 공지사항 상세정보를 반환한다") {
                    notice shouldBe allNotices.body.map { it.id == 1L }
                }
            }
        }
    }

    companion object {
        private val noticeResponse = NoticeResponse(
            body = listOf(
                NoticeList(
                    id = 1,
                    title = "title 1",
                    content = "content 1",
                    role = "",
                    createdDate = LocalDateTime.now()
                )
            )
        )

        private val noticeDetailResponse = NoticeDetailResponse(
            id = 1,
            title = "title 1",
            content = "content 1",
            role = "",
            noticeFile = listOf(
                NoticeFile(
                    id = 1,
                    url = ""
                )
            ),
            createdDate = LocalDateTime.now()
        )

        var noticeMap = HashMap<String, RequestBody>()

        val file = File("파일 경로")
        val filePart = MultipartBody.Part.createFormData(
            "file",
            file.name,
            file.asRequestBody("multipart/form-data".toMediaType())
        )
    }
}