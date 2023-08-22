package com.mpersand.presentation.view.notice.list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.notice.list.NoticeListScreen

const val noticeListRoute = "notice_list_route"

fun NavController.navigateToNoticeList() {
    this.navigate(noticeListRoute)
}

fun NavGraphBuilder.noticeListScreen() {
    composable(noticeListRoute) {
        NoticeListScreen()
    }
}