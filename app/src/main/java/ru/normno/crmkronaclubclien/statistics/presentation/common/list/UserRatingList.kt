@file:OptIn(ExperimentalLayoutApi::class)

package ru.normno.crmkronaclubclien.statistics.presentation.common.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.normno.crmkronaclubclien.statistics.domain.model.User
import ru.normno.crmkronaclubclien.statistics.util.Dimens.mediumAvatar
import ru.normno.crmkronaclubclien.statistics.util.Dimens.specialAchievement

@Composable
fun UserRatingList(
    modifier: Modifier = Modifier,
    users: List<User>,
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(
            items = users,
            key = {
                it.id
            }
        ) { user ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(4.dp)),
            ) {
                ListItem(
                    colors = ListItemColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        headlineColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        leadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        overlineColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        supportingTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        trailingIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        disabledHeadlineColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(
                            0.7f
                        ),
                        disabledLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                            0.7f
                        ),
                        disabledTrailingIconColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(
                            0.7f
                        ),
                    ),
                    overlineContent = {
                        Text(
                            text = "${user.firstName} ${user.lastName}",
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                    headlineContent = {
                        Column {
                            Text(
                                text = user.positionInCompany,
                                style = MaterialTheme.typography.titleSmall,
                            )
                            val moreOrCollapseIndicator =
                                @Composable { scope: ContextualFlowRowOverflowScope ->
                                    val remainingItems =
                                        user.achievements.size - scope.shownItemCount
                                    Text(text = "+$remainingItems")
                                }
                            AchievementsList(
                                achievements = user.achievements,
                                maxLines = 1,
                                maxItemsInEachRow = 4,
                                moreOrCollapseIndicator = moreOrCollapseIndicator,
                            )
                        }
                    },
                    leadingContent = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = user.globalRating.toString(),
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(
                                text = user.localRating.toString(),
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier
                                    .align(Alignment.Bottom),
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(4.dp)
                            )
                            AsyncImage(
                                model = user.avatar,
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .height(mediumAvatar),
                            )
                        }
                    },
                    trailingContent = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            AsyncImage(
                                model = user.specialAchievement?.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(specialAchievement),
                            )
                            Text(
                                text = "%.1f".format(user.score),
                                style = MaterialTheme.typography.displaySmall,
                            )
                        }
                    },
                )
            }
        }
    }
}