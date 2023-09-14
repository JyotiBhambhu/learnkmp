package com.jyoti.learnkmp.android.feature.launch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.jyoti.learnkmp.domain.RocketLaunchesUseCase

@Composable
fun LaunchRoute(onLaunchClick: (launchId: String) -> Unit) {
    var rocketLaunches: List<RocketLaunch> by remember { mutableStateOf(emptyList()) }
    LaunchedEffect(key1 = Unit, block = {
        rocketLaunches = try {
            RocketLaunchesUseCase().invoke()
        } catch (e: Exception) {
            listOf()
        }
    })
    LazyColumn {
        items(rocketLaunches) {
            LaunchItem(it, onClick = onLaunchClick)
        }
    }
}

@Composable
private fun LaunchItem(launchInfo: RocketLaunch, onClick: (launchId: String) -> Unit) {
    ListItem(
        modifier = Modifier.clickable { launchInfo.id?.let { onClick(it) } },
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
                model = launchInfo.links?.patch?.small,
//                placeholder = painterResource(R.drawable.ic_placeholder),
//                error = painterResource(R.drawable.ic_placeholder),
                contentDescription = "Mission patch"
            )
        }
    )
}
