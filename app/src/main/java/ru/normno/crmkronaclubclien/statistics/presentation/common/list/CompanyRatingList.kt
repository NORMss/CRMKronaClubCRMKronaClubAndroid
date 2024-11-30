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
import ru.normno.crmkronaclubclien.statistics.domain.model.Company
import ru.normno.crmkronaclubclien.statistics.util.Dimens.mediumAvatar
import ru.normno.crmkronaclubclien.statistics.util.Dimens.specialAchievement

@Composable
fun CompanyRatingList(
    modifier: Modifier = Modifier,
    companies: List<Company>,
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(
            items = companies,
            key = {
                it.id
            }
        ) { company ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(4.dp)),
            ) {
                ListItem(
                    colors = ListItemColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        headlineColor = MaterialTheme.colorScheme.onTertiaryContainer,
                        leadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        overlineColor = MaterialTheme.colorScheme.onTertiaryContainer,
                        supportingTextColor = MaterialTheme.colorScheme.onTertiaryContainer,
                        trailingIconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                        disabledHeadlineColor = MaterialTheme.colorScheme.onTertiaryContainer.copy(
                            0.7f
                        ),
                        disabledLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                            0.7f
                        ),
                        disabledTrailingIconColor = MaterialTheme.colorScheme.onTertiaryContainer.copy(
                            0.7f
                        ),
                    ),
                    overlineContent = {
                        Text(
                            text = "${company.city}, ${company.name}",
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                    headlineContent = {
                        Column {
                            Text(
                                text = "Сотрудников в компании: ${company.users.size.toString()}",
                                style = MaterialTheme.typography.titleSmall,
                            )
                            company.achievements?.let {
                                val moreOrCollapseIndicator =
                                    @Composable { scope: ContextualFlowRowOverflowScope ->
                                        val remainingItems =
                                            company.achievements.size - scope.shownItemCount
                                        Text(text = "+$remainingItems")
                                    }
                                AchievementsList(
                                    achievements = company.achievements,
                                    maxLines = 1,
                                    moreOrCollapseIndicator = moreOrCollapseIndicator,
                                )
                            }
                        }
                    },
                    leadingContent = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = company.globalRating.toString(),
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(
                                text = company.localRating.toString(),
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
                                model = company.avatar,
                                contentDescription = null,
                                modifier = Modifier
                                    .height(mediumAvatar),
                            )

                        }
                    },
                    trailingContent = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            AsyncImage(
                                model = company.specialAchievement?.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(specialAchievement),
                            )
                            Text(
                                text = "%.1f".format(company.score),
                                style = MaterialTheme.typography.displaySmall,
                            )
                        }
                    },
                )
            }
        }
    }
}