package com.example.testApp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.testApp.ui.home.HomeViewModel
import com.example.testApp.ui.navigation.AppNavigation
import com.example.testApp.ui.navigation.Screens
import com.example.testApp.ui.theme.TestAppTheme
import com.example.testApp.utils.SetStatusBarAndNavBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vmDictionary = inflateDictionary()
        setContent {
            TestAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    SetStatusBarAndNavBar()
                    AppNavigation(vmDictionary)
                }
            }
        }
    }



    private fun inflateDictionary(): Map<String, ViewModel> {
        val vmDictionary = mutableMapOf<String, ViewModel>()
        vmDictionary[Screens.HomeScreen.route] = homeViewModel
        return vmDictionary
    }
}

