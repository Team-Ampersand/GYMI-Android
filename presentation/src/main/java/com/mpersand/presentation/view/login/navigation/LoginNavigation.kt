package com.mpersand.presentation.view.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.login.LoginScreen

const val loginRoute = "login_route"

fun NavController.navigateToLogin() {
    this.navigate(loginRoute)
}

fun NavGraphBuilder.loginScreen() {
    composable(loginRoute) {
        LoginScreen()
    }
}