package com.mpersand.presentation.view.equipment.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mpersand.presentation.view.equipment.EquipmentScreen

const val equipmentRoute = "equipment_route"

fun NavController.navigateToEquipment() {
    this.navigate(equipmentRoute)
}

fun NavGraphBuilder.equipmentScreen() {
    composable(equipmentRoute) {
        EquipmentScreen()
    }
}