@file:OptIn(ExperimentalLayoutApi::class)

package ru.normno.crmkronaclubclien.statistics.presentation.user

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.normno.crmkronaclubclien.statistics.domain.model.User
import ru.normno.crmkronaclubclien.statistics.presentation.common.AvatarBox
import ru.normno.crmkronaclubclien.statistics.presentation.common.list.AchievementsList
import ru.normno.crmkronaclubclien.statistics.util.WindowType
import ru.normno.crmkronaclubclien.statistics.util.rememberWindowSize

@Composable
fun ProfileScreen(
    user: User,
    modifier: Modifier = Modifier,
) {
    val windowSize = rememberWindowSize()
    when (windowSize.with) {
        WindowType.Compact ->
            CompactProfileScreen(user, modifier)

        else -> MediumToExpandedProfileScreen(user)
    }
}

@Composable
fun CompactProfileScreen(user: User, modifier: Modifier = Modifier) {
    val moreOrCollapseIndicator =
        @Composable { scope: ContextualFlowRowOverflowScope ->
            val remainingItems =
                user.achievements.size - scope.shownItemCount
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
        AvatarBox(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .size(256.dp)
                .background(MaterialTheme.colorScheme.primary)
                .align(Alignment.CenterHorizontally),
            avatar = user.avatar,
            firstName = user.firstName,
            lastName = user.lastName,
            fontSize = 128.sp
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Text(
            text = "${user.firstName} ${user.lastName}",
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
        if (user.achievements.isNotEmpty()) {
            AchievementsList(
                achievements = user.achievements,
                moreOrCollapseIndicator = moreOrCollapseIndicator,
            )
            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )
        }

        UserInfo(
            title = "Филиал",
            content = "${user.city}, ${user.name}",
        )

        UserInfo(
            title = "Глобальный рейтинг",
            content = user.globalRating.toString()
        )

        UserInfo(
            title = "Рейтинг внутри филиала",
            content = user.localRating.toString()
        )
    }
}

@Composable
fun MediumToExpandedProfileScreen(user: User, modifier: Modifier = Modifier) {
    val moreOrCollapseIndicator =
        @Composable { scope: ContextualFlowRowOverflowScope ->
            val remainingItems =
                user.achievements.size - scope.shownItemCount
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
                AvatarBox(
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp))
                        .size(256.dp)
                        .background(MaterialTheme.colorScheme.primary),
                    avatar = user.avatar,
                    firstName = user.firstName,
                    lastName = user.lastName,
                    fontSize = 128.sp
                )
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )
                Text(
                    text = "${user.firstName} ${user.lastName}",
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
                    content = "${user.city}, ${user.name}",
                )

                AchievementsList(
                    achievements = user.achievements,
                    moreOrCollapseIndicator = moreOrCollapseIndicator,
                )

                UserInfo(
                    title = "Филиал",
                    content = "${user.city}, ${user.name}",
                )

                UserInfo(
                    title = "Глобальный рейтинг",
                    content = user.globalRating.toString()
                )

                UserInfo(
                    title = "Рейтинг внутри филиала",
                    content = user.localRating.toString()
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