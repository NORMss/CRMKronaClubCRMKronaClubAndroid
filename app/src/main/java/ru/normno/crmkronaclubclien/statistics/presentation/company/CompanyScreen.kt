@file:OptIn(ExperimentalLayoutApi::class)

package ru.normno.crmkronaclubclien.statistics.presentation.company

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.normno.crmkronaclubclien.statistics.domain.model.Company
import ru.normno.crmkronaclubclien.statistics.presentation.common.list.AchievementsList
import ru.normno.crmkronaclubclien.statistics.util.WindowType
import ru.normno.crmkronaclubclien.statistics.util.rememberWindowSize

@Composable
fun CompanyScreen(
    company: Company,
    modifier: Modifier = Modifier,
) {
    val windowSize = rememberWindowSize()
    when (windowSize.with) {
        WindowType.Compact ->
            CompactProfileScreen(company, modifier)

        else -> MediumToExpandedProfileScreen(company)
    }
}

@Composable
fun CompactProfileScreen(company: Company, modifier: Modifier = Modifier) {
    val moreOrCollapseIndicator =
        @Composable { scope: ContextualFlowRowOverflowScope ->
            val remainingItems =
                company.achievements.size - scope.shownItemCount
            Text(text = "+$remainingItems")
        }
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
                .height(36.dp)
        )
        AsyncImage(
            model = company.avatar,
            contentDescription = null,
            modifier = Modifier
                .size(256.dp),
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Text(
            text = "${company.city}, ${company.name}",
            style = MaterialTheme.typography.displaySmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
        Spacer(
            modifier = Modifier
                .height(64.dp)
        )
        if (company.achievements.isNotEmpty()) {
            AchievementsList(
                achievements = company.achievements,
                moreOrCollapseIndicator = moreOrCollapseIndicator,
            )
            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )
        }

        UserInfo(
            title = "Филиал",
            content = "${company.city}, ${company.name}",
        )

        UserInfo(
            title = "Глобальный рейтинг",
            content = company.globalRating.toString()
        )

        UserInfo(
            title = "Рейтинг внутри филиала",
            content = company.localRating.toString()
        )
    }
}

@Composable
fun MediumToExpandedProfileScreen(company: Company, modifier: Modifier = Modifier) {
    val moreOrCollapseIndicator =
        @Composable { scope: ContextualFlowRowOverflowScope ->
            val remainingItems =
                company.achievements.size - scope.shownItemCount
            Text(text = "+$remainingItems")
        }
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(36.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                AsyncImage(
                    model = company.avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(256.dp),
                )
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )
                Text(
                    text = "${company.city}, ${company.name}",
                    style = MaterialTheme.typography.displaySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(
                modifier = Modifier
                    .width(128.dp)
            )

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
            ) {
                UserInfo(
                    title = "Филиал",
                    content = "${company.city}, ${company.name}",
                )

                AchievementsList(
                    achievements = company.achievements,
                    moreOrCollapseIndicator = moreOrCollapseIndicator,
                )

                UserInfo(
                    title = "Филиал",
                    content = "${company.city}, ${company.name}",
                )

                UserInfo(
                    title = "Количество сотрудников",
                    content = company.users.size.toString(),
                )

                UserInfo(
                    title = "Глобальный рейтинг",
                    content = company.globalRating.toString()
                )

                UserInfo(
                    title = "Рейтинг внутри филиала",
                    content = company.localRating.toString()
                )
            }
        }
    }
}

@Composable
fun UserInfo(
    title: String,
    content: String,
) {
    Column {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            modifier = Modifier
                .alpha(0.7f)
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Text(
            text = content,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(
            modifier = Modifier
                .height(32.dp)
        )
    }
}