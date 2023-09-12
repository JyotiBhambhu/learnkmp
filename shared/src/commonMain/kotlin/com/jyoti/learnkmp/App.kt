package com.jyoti.learnkmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jyoti.learnkmp.domain.Greeting
import com.jyoti.learnkmp.util.getPlatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            var selectedTab by remember { mutableStateOf(0) }
            var greetingText by remember { mutableStateOf("Hello, World!") }
            var text by remember { mutableStateOf("Loading") }
            LaunchedEffect(key1 = Unit, block = {
                text = try {
                    Greeting().greet()
                } catch (e: Exception) {
                    e.message ?: "error"
                }
            })
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TabRow(selectedTab) {
                    Tab(selectedTab == 0, content = {
                        Text(modifier = Modifier.padding(16.dp), text = greetingText)
                    }, onClick = {
                        selectedTab = 0
                        greetingText = "Hello, ${getPlatform().name}"
                    })
                    Tab(selectedTab == 1, content = {
                        Text(modifier = Modifier.padding(16.dp), text = "Rocket Info")
                    }, onClick = {
                        selectedTab = 1
                    })
                }
                when (selectedTab) {
                    0 -> {
                        AnimatedVisibility(selectedTab == 0) {
                            Image(
                                painterResource("compose-multiplatform.xml"),
                                null
                            )
                        }
                    }

                    1 -> {
                        Text(text)
                    }
                }

            }
        }
    }
}
