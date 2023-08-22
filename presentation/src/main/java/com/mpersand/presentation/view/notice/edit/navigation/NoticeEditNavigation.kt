package com.mpersand.presentation.view.notice.edit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.notice.edit.NoticeEditScreen

const val noticeEditRoute = "notice_edit_route"

fun NavController.navigateToNoticeEdit() {
    this.navigate(noticeEditRoute)
}

fun NavGraphBuilder.noticeEditScreen(navigateToNotice: () -> Unit) {
    composable(noticeEditRoute) {
        NoticeEditScreen(navigateToNotice = navigateToNotice)
    }
}