package com.jyoti.learnkmp.android.feature.detail

import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jyoti.data.model.RocketLaunch
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailRoute(viewModel: DetailViewModel = koinViewModel(), id: String) {
    val state by viewModel.screenState.collectAsState()
    LaunchedEffect(key1 = Unit, block = {
        viewModel.fetchRocketInfo(id)
    })
    state?.let { LaunchItem(it) }
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