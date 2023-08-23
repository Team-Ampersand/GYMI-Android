package com.mpersand.gymi_android.navigation

import androidx.navigation.NavController

fun NavController.navigateToDestination(route: String) {
    val startRoute = this.graph.startDestinationRoute

    this.navigate(route) {
        startRoute?.let {
            popUpTo(it)
        }
        launchSingleTop = true
    }
}