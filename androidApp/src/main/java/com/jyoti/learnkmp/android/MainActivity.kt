package com.jyoti.learnkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jyoti.learnkmp.android.feature.detail.detailScreen
import com.jyoti.learnkmp.android.feature.detail.navigateToDetail
import com.jyoti.learnkmp.android.feature.launch.launchRoute
import com.jyoti.learnkmp.android.feature.launch.launchScreen
import com.jyoti.learnkmp.findElementInList

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findElementInList(1, listOf(1, 2, 3))
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Scaffold { padding ->
                       Box(
                           Modifier
                               .fillMaxSize()
                               .padding(padding)
                               .consumeWindowInsets(padding)
                               .windowInsetsPadding(
                                   WindowInsets.safeDrawing.only(
                                       WindowInsetsSides.Horizontal,
                                   ),
                               ),
                       ) {
                           val navController = rememberNavController()
                           NavHost(navController = navController, startDestination = launchRoute){
                               launchScreen{
                                   navController.navigateToDetail(it)
                               }
                               detailScreen()
                           }
                       }
                   }
                }
            }
        }
    }
}


