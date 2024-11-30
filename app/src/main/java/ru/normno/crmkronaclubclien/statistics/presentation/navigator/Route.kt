package ru.normno.crmkronaclubclien.statistics.presentation.navigator

import kotlinx.serialization.Serializable
import ru.normno.crmkronaclubclien.statistics.domain.model.Company
import ru.normno.crmkronaclubclien.statistics.domain.model.User

@Serializable
sealed class Route {
    @Serializable
    data object Login : Route()

    @Serializable
    data object Rating : Route()

    @Serializable
    data object LoginScreen : Route()

    @Serializable
    data object UsersRatingScreen : Route()

    @Serializable
    data object CompanyRatingScreen : Route()

    @Serializable
    data class ProfileScreen(val user: User) : Route()

    @Serializable
    data class CompanyScreen(val company: Company) : Route()

    @Serializable
    data object InfoScreen : Route()
}