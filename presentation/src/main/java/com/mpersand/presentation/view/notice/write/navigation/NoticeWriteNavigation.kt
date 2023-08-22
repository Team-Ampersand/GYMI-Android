package com.mpersand.presentation.view.notice.write.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.notice.write.NoticeWriteScreen

const val noticeWriteRoute = "notice_write_route"

fun NavController.navigateToNoticeWrite() {
    this.navigate(noticeWriteRoute)
}

fun NavGraphBuilder.noticeWriteScreen(navigateToNotice: () -> Unit) {
    composable(noticeWriteRoute) {
        NoticeWriteScreen(navigateToNotice = navigateToNotice)
    }
}