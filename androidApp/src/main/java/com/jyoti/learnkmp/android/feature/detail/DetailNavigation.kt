package com.jyoti.learnkmp.android.feature.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val detailRoute = "detail_route"
internal const val idArg = "launchId"

fun NavController.navigateToDetail(id: String) {
    this.navigate("$detailRoute?$idArg=$id")
}

fun NavGraphBuilder.detailScreen() {
    composable(
        "$detailRoute?$idArg={$idArg}", arguments = listOf(navArgument(
            idArg
        ) {
            type = NavType.StringType
            nullable = false
            defaultValue = ""
        })
    ) {
        DetailRoute(id = it.arguments?.getString(idArg) ?: "")
    }
}