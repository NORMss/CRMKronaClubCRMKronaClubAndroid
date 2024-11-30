package ru.normno.crmkronaclubclien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ru.normno.crmkronaclubclien.statistics.domain.model.Achievement
import ru.normno.crmkronaclubclien.statistics.domain.model.Company
import ru.normno.crmkronaclubclien.statistics.domain.model.User
import ru.normno.crmkronaclubclien.statistics.presentation.common.list.CompanyRatingList
import ru.normno.crmkronaclubclien.ui.theme.CRMKronaClubClientAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CRMKronaClubClientAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    UserRatingList(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding),
//                        users = users,
//                    )
                    CompanyRatingList(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        companies = companies,
                    )
//                    ProfileScreen(
//                        user = users[2],
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(
//                                top = innerPadding.calculateTopPadding(),
//                                bottom = innerPadding.calculateTopPadding(),
//                            )
//                    )
                }
            }
        }
    }

    val users = listOf(
        User(
            id = 1,
            companyId = 1,
            rating = 95,
            city = "Новосибирск",
            name = "Филиал 1",
            firstName = "Ivan",
            lastName = "Petrov",
            globalRating = 1,
            localRating = 12,
            positionInCompany = "Software Engineer",
            avatar = "https://xsgames.co/randomusers/assets/avatars/male/1.jpg",
            score = 4.8f,
            specialAchievement = null,
            achievements = emptyList(),
        ),
        User(
            id = 2,
            companyId = 1,
            rating = 87,
            city = "Новосибирск",
            name = "Филиал 1",
            firstName = "Sergey",
            lastName = "Ivanov",
            globalRating = 2,
            localRating = 1,
            positionInCompany = "Product Manager",
            avatar = "https://xsgames.co/randomusers/assets/avatars/male/15.jpg",
            score = 4.5f,
            specialAchievement = Achievement(
                name = "",
                description = "",
                image = "https://em-content.zobj.net/source/apple/391/fire_1f525.png"
            ),
            achievements = emptyList()
        ),
        User(
            id = 3,
            companyId = 1,
            rating = 92,
            city = "Новосибирск",
            name = "Филиал 1",
            firstName = "Alexey",
            lastName = "Smirnov",
            globalRating = 3,
            localRating = 7,
            positionInCompany = "Team Lead",
            avatar = "https://xsgames.co/randomusers/assets/avatars/male/30.jpg",
            score = 4.7f,
            specialAchievement = Achievement(
                name = "",
                description = "",
                image = "https://em-content.zobj.net/source/apple/391/fire_1f525.png"
            ),
            achievements = listOf(
                Achievement(
                    name = "",
                    description = "",
                    image = "https://em-content.zobj.net/source/apple/391/light-bulb_1f4a1.png"
                ),
                Achievement(
                    name = "",
                    description = "",
                    image = "https://em-content.zobj.net/source/apple/391/light-bulb_1f4a1.png"
                ),
                Achievement(
                    name = "",
                    description = "",
                    image = "https://em-content.zobj.net/source/apple/391/light-bulb_1f4a1.png"
                ),
                Achievement(
                    name = "",
                    description = "",
                    image = "https://em-content.zobj.net/source/apple/391/light-bulb_1f4a1.png"
                ),
                Achievement(
                    name = "",
                    description = "",
                    image = "https://em-content.zobj.net/source/apple/391/light-bulb_1f4a1.png"
                )
            )
        ),
        User(
            id = 4,
            companyId = 1,
            city = "Новосибирск",
            name = "Филиал 1",
            rating = 85,
            firstName = "Dmitry",
            lastName = "Sokolov",
            globalRating = 4,
            localRating = 1,
            positionInCompany = "Data Analyst",
            avatar = "https://xsgames.co/randomusers/assets/avatars/male/45.jpg",
            score = 4.3f,
            specialAchievement = null,
            achievements = emptyList(),
        ),
        User(
            id = 5,
            companyId = 1,
            rating = 90,
            firstName = "Andrey",
            lastName = "Kuznetsov",
            city = "Новосибирск",
            name = "Филиал 1",
            globalRating = 5,
            localRating = 3,
            positionInCompany = "DevOps Engineer",
            avatar = "https://xsgames.co/randomusers/assets/avatars/male/70.jpg",
            score = 4.6f,
            specialAchievement = Achievement(
                name = "",
                description = "",
                image = "https://em-content.zobj.net/source/apple/391/fire_1f525.png"
            ),
            achievements = emptyList(),
        )
    )

    val companies = listOf(
        Company(
            id = 1L,
            city = "Новосибирск",
            name = "Филиал 1",
            avatar = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Coat_of_arms_of_Novosibirsk_oblast.svg/210px-Coat_of_arms_of_Novosibirsk_oblast.svg.png",
            globalRating = 1,
            localRating = 2,
            users = setOf(1L, 2L, 4L),
            score = 56.5f,
            specialAchievement = null,
            achievements = emptyList(),
        ),
        Company(
            id = 2L,
            city = "Новосибирск",
            name = "Филиал 1",
            avatar = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Coat_of_arms_of_Novosibirsk_oblast.svg/210px-Coat_of_arms_of_Novosibirsk_oblast.svg.png",
            globalRating = 1,
            localRating = 2,
            users = setOf(1L, 2L, 4L),
            score = 56.5f,
            specialAchievement = null,
            achievements = emptyList(),
        ),
        Company(
            id = 3L,
            city = "Москва",
            name = "Филиал 1",
            avatar = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Coat_of_arms_of_Moscow.svg/210px-Coat_of_arms_of_Moscow.svg.png",
            globalRating = 1,
            localRating = 2,
            users = setOf(1L, 2L, 4L),
            score = 56.5f,
            specialAchievement = Achievement(
                name = "",
                description = "",
                image = "https://em-content.zobj.net/source/apple/391/fire_1f525.png"
            ),
            achievements = emptyList(),
        )

    )
}