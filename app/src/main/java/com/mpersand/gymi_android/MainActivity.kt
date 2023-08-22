package com.mpersand.gymi_android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mpersand.gymi_components.component.header.GYMIHeader
import com.mpersand.gymi_components.component.navbar.GYMINavBar
import com.mpersand.gymi_components.component.navbar.GYMINavItem
import com.mpersand.gymi_components.theme.GYMITheme
import com.mpersand.gymi_components.theme.IcEquipment
import com.mpersand.gymi_components.theme.IcHome
import com.mpersand.gymi_components.theme.IcReservation
import com.mpersand.presentation.view.equipment.navigation.equipmentRoute
import com.mpersand.presentation.view.login.navigation.loginRoute
import com.mpersand.presentation.view.main.navigation.mainRoute
import com.mpersand.presentation.view.main.navigation.navigateToMain
import com.mpersand.presentation.view.notice.list.navigation.navigateToNoticeList
import com.mpersand.presentation.view.profile.navigation.navigateToProfile
import com.mpersand.presentation.view.reservation.navigation.reservationRoute

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GYMITheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        GYMIHeader(
                            navigateToMain = { navController.navigateToMain() },
                            navigateToNotice = { navController.navigateToNoticeList() },
                            navigationToProfile = { navController.navigateToProfile() }
                        )
                    },
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route
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
                                        navController.navigate(destination)
                                    }
                                }
                            }
                        }
                    }
                ) {
                    GYMINavHost(
                        navController = navController,
                        startDestination = loginRoute
                    )
                }
            }
        }
    }
}