package com.nguyenminhkhang.jarvisai.presentation.screens

import androidx.compose.runtime.Composable

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

@Composable
fun LoginScreen() {

}