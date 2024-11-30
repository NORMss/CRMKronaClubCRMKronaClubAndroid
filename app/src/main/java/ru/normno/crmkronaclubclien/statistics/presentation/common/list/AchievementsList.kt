@file:OptIn(ExperimentalLayoutApi::class)

package ru.normno.crmkronaclubclien.statistics.presentation.common.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.normno.crmkronaclubclien.statistics.domain.model.Achievement
import ru.normno.crmkronaclubclien.statistics.presentation.common.AchievementItem
import ru.normno.crmkronaclubclien.statistics.util.Dimens.achievementItemSize

@Composable
fun AchievementsList(
    achievements: List<Achievement>,
    maxLines: Int? = null,
    maxItemsInEachRow: Int? = null,
    moreOrCollapseIndicator: @Composable (ContextualFlowRowOverflowScope) -> Unit,
) {
    ContextualFlowRow(
        modifier = Modifier.fillMaxWidth(),
        maxLines = maxLines ?: Int.MAX_VALUE,
        maxItemsInEachRow = maxItemsInEachRow ?: Int.MAX_VALUE,
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = moreOrCollapseIndicator,
            collapseIndicator = moreOrCollapseIndicator,
        ),
        itemCount = achievements.size,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) { inedex ->
        AchievementItem(
            achievement = achievements[inedex],
            size = achievementItemSize,
        )
    }
}