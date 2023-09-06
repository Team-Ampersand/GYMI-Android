package com.mpersand.domain.usecase.notice

import com.mpersand.domain.repository.NoticeRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class CreateNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = kotlin.runCatching { noticeRepository.createNotice(notice, file) }
}