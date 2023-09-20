package com.jyoti.learnkmp.android.feature.launch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jyoti.data.model.RocketLaunch
import org.koin.androidx.compose.koinViewModel

@Composable
fun LaunchRoute(viewModel: LaunchViewModel = koinViewModel(), onLaunchClick: (launchId: String) -> Unit) {
    val state by viewModel.screenState.collectAsState()
    LazyColumn {
        items(state) {
            LaunchItem(it, onClick = onLaunchClick)
        }
    }
}

@Composable
private fun LaunchItem(launchInfo: com.jyoti.data.model.RocketLaunch, onClick: (launchId: String) -> Unit) {
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
