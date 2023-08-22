package com.mpersand.presentation.view.notice.empty.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.notice.empty.NoticeEmptyScreen

const val noticeEmptyRoute = "notice_empty_route"

fun NavController.navigateToNoticeEmpty() {
    this.navigate(noticeEmptyRoute)
}

fun NavGraphBuilder.noticeEmptyScreen() {
    composable(noticeEmptyRoute) {
        NoticeEmptyScreen()
    }
}
