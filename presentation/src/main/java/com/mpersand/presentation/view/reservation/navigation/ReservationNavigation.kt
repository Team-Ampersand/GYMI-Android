package com.mpersand.presentation.view.reservation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.reservation.ReservationScreen

const val reservationRoute = "reservation_route"

fun NavController.navigateToReservation() {
    this.navigate(reservationRoute)
}

fun NavGraphBuilder.reservationScreen() {
    composable(reservationRoute) {
        ReservationScreen()
    }
}