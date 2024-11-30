package ru.normno.crmkronaclubclien.statistics.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import coil3.compose.AsyncImage

@Composable
fun AvatarBox(
    modifier: Modifier = Modifier,
    avatar: String,
    firstName: String,
    lastName: String,
    fontSize: TextUnit,
) {
    var showMonogram by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier,
    ) {
        AsyncImage(
            model = avatar,
            contentDescription = null,
            onError = {
                showMonogram = true
            },
            modifier = Modifier
                .fillMaxSize()
        )
        if (showMonogram) {
            Text(
                text = "${firstName.first()} ${lastName.first()}",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = fontSize,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}