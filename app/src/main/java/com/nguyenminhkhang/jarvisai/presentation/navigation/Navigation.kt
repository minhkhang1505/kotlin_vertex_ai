package com.nguyenminhkhang.jarvisai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nguyenminhkhang.jarvisai.presentation.screens.account.AccountScreen
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.LoginScreen
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.SignUpScreen

@Composable
fun Navigation() {
    // Navigation implementation will go here
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        // Define composable destinations here
        composable (route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.SignUpScreen.route
        ) {
            SignUpScreen(navController = navController)
        }

        composable (
            route = Screen.AccountScreen.route
        ) {
            AccountScreen(navController = navController)
        }
    }
}