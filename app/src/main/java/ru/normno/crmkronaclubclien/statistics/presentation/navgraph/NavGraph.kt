package ru.normno.crmkronaclubclien.statistics.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import ru.normno.crmkronaclubclien.statistics.presentation.common.list.UserRatingList
import ru.normno.crmkronaclubclien.statistics.presentation.navigator.Route

@Composable
fun NavGraph(
    startDestination: Route,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation<Route.Login>(
            startDestination = Route.LoginScreen
        ) {
            composable<Route.LoginScreen> {

            }
        }
        navigation<Route.Rating>(
            startDestination = Route.UsersRatingScreen
        ) {
            composable<Route.UsersRatingScreen> {

            }
        }
    }
}