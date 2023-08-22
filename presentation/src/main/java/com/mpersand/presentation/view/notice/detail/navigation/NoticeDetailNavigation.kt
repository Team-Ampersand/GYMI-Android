package com.mpersand.presentation.view.notice.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.notice.detail.NoticeDetailScreen

const val noticeDetailRoute = "notice_detail_route"

fun NavController.navigateToNoticeDetail() {
    this.navigate(noticeDetailRoute)
}

fun NavGraphBuilder.noticeDetailScreen(navigationNotice: () -> Unit) {
    composable(noticeDetailRoute) {
        NoticeDetailScreen(navigateToNotice = navigationNotice)
    }
}