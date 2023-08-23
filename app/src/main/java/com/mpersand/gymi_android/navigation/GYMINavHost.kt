package com.mpersand.gymi_android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mpersand.presentation.view.equipment.navigation.equipmentScreen
import com.mpersand.presentation.view.login.navigation.loginScreen
import com.mpersand.presentation.view.main.navigation.mainScreen
import com.mpersand.presentation.view.notice.detail.navigation.noticeDetailScreen
import com.mpersand.presentation.view.notice.edit.navigation.noticeEditScreen
import com.mpersand.presentation.view.notice.empty.navigation.noticeEmptyScreen
import com.mpersand.presentation.view.notice.list.navigation.navigateToNoticeList
import com.mpersand.presentation.view.notice.list.navigation.noticeListScreen
import com.mpersand.presentation.view.notice.write.navigation.noticeWriteScreen
import com.mpersand.presentation.view.profile.navigation.profileScreen
import com.mpersand.presentation.view.reservation.navigation.reservationScreen

@Composable
fun GYMINavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        equipmentScreen()
        loginScreen()
        mainScreen()
        noticeEmptyScreen()
        noticeListScreen()
        noticeDetailScreen { navController.navigateToNoticeList() }
        noticeEditScreen { navController.navigateToNoticeList() }
        noticeWriteScreen { navController.navigateToNoticeList() }
        profileScreen()
        reservationScreen()
    }
}