package com.example.modernandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.modernandroid.ui.theme.ModernAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //이 액티비티의 모든 객체는 의존성 주입을 사용할 수 있음
class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InitNavigation()
                }
            }
        }
    }
}

@Preview
@Composable
fun InitNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            Screen.Second.route + "/{theName}",
            arguments = listOf(navArgument("theName") { type = NavType.StringType })
        ) {
            SecondScreen(navController = navController, it)
        }
        composable(Screen.Last.route) {
            LastScreen(navController = navController)
        }
    }
}
