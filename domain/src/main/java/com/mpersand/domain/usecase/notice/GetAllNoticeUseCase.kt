package com.mpersand.domain.usecase.notice

import com.mpersand.domain.repository.NoticeRepository
import javax.inject.Inject

class GetAllNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { noticeRepository.getAllNotice() }
}