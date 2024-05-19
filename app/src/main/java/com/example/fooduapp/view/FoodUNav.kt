package com.example.fooduapp.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooduapp.FoodUAppState
import com.example.fooduapp.HOME_NAV
import com.example.fooduapp.HOME_SCREEN
import com.example.fooduapp.SIGN_IN_SCREEN
import com.example.fooduapp.SIGN_UP_SCREEN
import com.example.fooduapp.SPLASH_SCREEN

//enum class CupcakeScreen(@StringRes val title: Int) {
//    Start(title = R.string.app_name),
//    Flavor(title = R.string.choose_flavor),
//    Pickup(title = R.string.choose_pickup_date),
//    Summary(title = R.string.order_summary)
//}

@Composable
fun FoodUNavigation() {
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = CupcakeScreen.valueOf(
//        backStackEntry?.destination?.route ?: CupcakeScreen.Start.name
//    )
    val appState = rememberAppState()
    NavHost(
        navController = appState.navController,
        startDestination = SPLASH_SCREEN
    ) {
        foodGraph(appState)
    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        FoodUAppState(navController)
    }

fun NavGraphBuilder.foodGraph(appState: FoodUAppState) {
    composable(route = SPLASH_SCREEN) {
        SplashScreen(
            openAndPopUp = {
                route, popUp -> appState.navigateAndPopUp(route, popUp)
            }
        )
    }

    composable(route = SIGN_IN_SCREEN) {
        SignInScreen(
            openAndPopUp = {
                    route, popUp -> appState.navigateAndPopUp(route, popUp)
            }
        )
    }

    composable(route = SIGN_UP_SCREEN) {
        SignUpScreen(
            openAndPopUp = {
                    route, popUp -> appState.navigateAndPopUp(route, popUp)
            }
        )
    }

    composable(route = HOME_NAV) {
        HomeNavScreen()
    }
}