package com.mpersand.data.repository

import com.mpersand.data.remote.datasource.notice.NoticeDataSource
import com.mpersand.data.remote.model.notice.response.asNoticeDetailResponseModel
import com.mpersand.data.remote.model.notice.response.asNoticeResponseModel
import com.mpersand.domain.model.notice.response.NoticeDetailResponseModel
import com.mpersand.domain.model.notice.response.NoticeResponseModel
import com.mpersand.domain.repository.NoticeRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val noticeDataSource: NoticeDataSource
): NoticeRepository {
    override suspend fun createNotice(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = noticeDataSource.createNotice(notice, file)

    override suspend fun deleteNotice(id: Long) = noticeDataSource.deleteNotice(id)

    override suspend fun modifyNotice(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = noticeDataSource.modifyNotice(id, notice, file)

    override suspend fun getAllNotice(): List<NoticeResponseModel> = noticeDataSource.getAllNotice().map { it.asNoticeResponseModel() }

    override suspend fun getDetailNotice(id: Long): NoticeDetailResponseModel = noticeDataSource.getDetailNotice(id).asNoticeDetailResponseModel()
}