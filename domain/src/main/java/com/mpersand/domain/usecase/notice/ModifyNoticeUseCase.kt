package com.mpersand.domain.usecase.notice

import com.mpersand.domain.repository.NoticeRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class ModifyNoticeUseCase @Inject constructor(
  private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(
        id: Long,
        notice: HashMap<String, RequestBody>,
        file: MultipartBody.Part
    ) = kotlin.runCatching { noticeRepository.modifyNotice(id, notice, file) }
}