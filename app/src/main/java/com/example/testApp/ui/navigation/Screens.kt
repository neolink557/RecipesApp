package com.example.testApp.ui.navigation

import com.example.testApp.utils.HOME_SCREEN
import com.example.testApp.utils.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object SplashScreen : Screens(SPLASH_SCREEN)
    object HomeScreen : Screens(HOME_SCREEN)
}