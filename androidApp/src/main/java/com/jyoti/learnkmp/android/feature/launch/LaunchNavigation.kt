package com.jyoti.learnkmp.android.feature.launch

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val launchRoute = "Launch_route"
fun NavGraphBuilder.launchScreen(onLaunchClick: (launchId: String) -> Unit){
    composable(route = launchRoute){
        LaunchRoute(onLaunchClick = onLaunchClick)
    }
}