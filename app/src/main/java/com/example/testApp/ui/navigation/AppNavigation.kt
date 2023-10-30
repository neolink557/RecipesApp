package com.example.testApp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testApp.ui.home.HomeScreen
import com.example.testApp.ui.home.HomeViewModel
import com.example.testApp.ui.splash.SplashScreen
import com.example.testApp.ui.splash.SplashViewModel

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavigation(viewModels: Map<String, ViewModel>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(
                navController = navController,
                viewModels[Screens.SplashScreen.route] as SplashViewModel
            )
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                viewModels[Screens.HomeScreen.route] as HomeViewModel
            )
        }
    }
}