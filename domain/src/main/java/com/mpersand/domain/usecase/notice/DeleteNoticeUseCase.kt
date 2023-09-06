package com.mpersand.domain.usecase.notice

import com.mpersand.domain.repository.NoticeRepository
import javax.inject.Inject

class DeleteNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(id: Long) = kotlin.runCatching { noticeRepository.deleteNotice(id) }
}