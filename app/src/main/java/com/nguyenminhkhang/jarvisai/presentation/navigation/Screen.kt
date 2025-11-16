package com.nguyenminhkhang.jarvisai.presentation.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login")
    object SignUpScreen : Screen("signup")
    object AccountScreen : Screen("account")
}