package com.mpersand.gymi_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mpersand.gymi_android.navigation.navigateToDestination
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcPlus
import com.mpersand.gymi_components.theme.IcReservation
import com.mpersand.gymi_components.theme.Theme
import com.mpersand.presentation.view.equipment.navigation.equipmentRoute
import com.mpersand.presentation.view.login.navigation.loginRoute
import com.mpersand.presentation.view.main.navigation.mainRoute
import com.mpersand.presentation.view.notice.list.navigation.noticeListRoute
import com.mpersand.presentation.view.notice.write.navigation.navigateToNoticeWrite
import com.mpersand.presentation.view.profile.navigation.profileRoute
import com.mpersand.presentation.view.reservation.navigation.reservationRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GYMITheme.gymiTheme = if (!isSystemInDarkTheme()) Theme.LIGHT else Theme.DARK

            GYMITheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        if (currentRoute != loginRoute) {
                            GYMIHeader(
                                navigateToMain = { navController.navigateToDestination(mainRoute) },
                                navigateToNotice = { navController.navigateToDestination(noticeListRoute) },
                                navigationToProfile = { navController.navigateToDestination(profileRoute) }
                            )
                        }
                    },
                    bottomBar = {
                        val destinations = listOf(reservationRoute, mainRoute, equipmentRoute)

                        if (currentRoute in destinations) {
                            GYMINavBar {
                                destinations.forEach { destination ->
                                    val selected = currentRoute?.let { destination == it } ?: false

                                    GYMINavItem(
                                        selected = selected,
                                        icon = {
                                            when (destination) {
                                                reservationRoute -> IcReservation(tint = LocalContentColor.current)
                                                mainRoute -> IcHome(tint = LocalContentColor.current)
                                                equipmentRoute -> IcEquipment(tint = LocalContentColor.current)
                                            }
                                        }
                                    ) {
                                        navController.navigateToDestination(destination)
                                    }
                                }
                            }
                        }
                    },
                    floatingActionButton = {
                        if (currentRoute == noticeListRoute) {
                            FloatingActionButton(
                                backgroundColor = GYMITheme.colors.n4,
                                onClick = { navController.navigateToNoticeWrite() }
                            ) {
                                IcPlus(tint = GYMITheme.colors.bw)
                            }
                        }
                    }
                ) { paddingValues ->
                    GYMINavHost(
                        modifier = Modifier
                            .padding(paddingValues)
                            .background(GYMITheme.colors.bg),
                        navController = navController,
                        startDestination = mainRoute
                    )
                }
            }
        }
    }
}