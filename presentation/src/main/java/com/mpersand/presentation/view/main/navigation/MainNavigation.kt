package com.mpersand.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.login.navigation.loginRoute
import com.mpersand.presentation.view.main.MainScreen

const val mainRoute = "main_route"

fun NavController.navigateToMain() {
    this.navigate(mainRoute) {
        popUpTo(loginRoute) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.mainScreen() {
    composable(mainRoute) {
        MainScreen()
    }
}