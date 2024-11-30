package ru.normno.crmkronaclubclien.statistics.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.normno.crmkronaclubclien.statistics.domain.model.Achievement

@Composable
fun AchievementItem(
    achievement: Achievement,
    size: Dp,
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
            .size(size)
            .padding(4.dp),
    ) {
        AsyncImage(
            model = achievement.image,
            contentDescription = achievement.description,
        )
    }
}