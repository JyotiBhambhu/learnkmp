package com.jyoti.learnkmp.android.feature.detail

import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jyoti.learnkmp.data.model.RocketLaunch
import com.jyoti.learnkmp.domain.RocketLaunchUseCase

@Composable
fun DetailRoute(id: String){
    var rocketLaunch: RocketLaunch? by remember { mutableStateOf(null) }
    LaunchedEffect(key1 = Unit, block = {
        rocketLaunch = try {
            RocketLaunchUseCase().invoke(id)
        } catch (e: Exception) {
            null
        }
    })
    rocketLaunch?.let { LaunchItem(it) }
}

@Composable
private fun LaunchItem(launchInfo: RocketLaunch) {
    ListItem(
        headlineContent = {
            // Mission name
            Text(text = launchInfo.missionName ?: "")
        },
        supportingContent = {
            // Site
            Text(text = launchInfo.details ?: "")
        },
        leadingContent = {
            // Mission patch
            AsyncImage(
                modifier = Modifier.size(68.dp, 68.dp),
                model = launchInfo.links?.patch?.large,
//                placeholder = painterResource(R.drawable.ic_placeholder),
//                error = painterResource(R.drawable.ic_placeholder),
                contentDescription = "Mission patch"
            )
        }
    )
}