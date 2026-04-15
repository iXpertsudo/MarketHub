
package com.victor.markethub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.victor.markethub.ui.screens.about.AboutScreen
import com.victor.markethub.ui.screens.auth.LoginScreen
import com.victor.markethub.ui.screens.auth.RegisterScreen
import com.victor.markethub.ui.screens.home.HomeScreen
import com.victor.markethub.ui.screens.Intent.IntentScreen
import com.victor.markethub.ui.screens.OnBoarding.OnboardingScreen
import com.victor.markethub.ui.screens.payments.PaymentsScreen
import com.victor.markethub.ui.screens.scaffold.ScaffoldScreen
import com.victor.markethub.ui.screens.service.ServiceScreen
import com.victor.markethub.ui.screens.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_Splash
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUTE_Home) {
            HomeScreen(navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUTE_Login) {
            LoginScreen(navController)
        }
        composable(ROUTE_Register) {
            RegisterScreen(navController)
        }
        composable(ROUTE_OnBoarding) {
            OnboardingScreen(navController)
        }

        composable(ROUTE_Payments) {
            PaymentsScreen(navController)
        }
        composable(ROUTE_Service) {
            ServiceScreen(navController)
        }

        composable(ROUTE_Intent) {
            IntentScreen(navController)
        }


        composable(ROUTE_Splash ) {
            SplashScreen(navController)
        }

        composable(ROUTE_Scaffold ) {
            ScaffoldScreen(navController)
        }






    }
}
