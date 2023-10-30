package com.example.testApp.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetStatusBarAndNavBar(
    statusBarColor: Color = MaterialTheme.colors.primary,
    navBarColor: Color = MaterialTheme.colors.background
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = statusBarColor
    )
    systemUiController.setNavigationBarColor(
        color = navBarColor
    )
}