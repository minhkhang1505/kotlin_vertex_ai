package com.nguyenminhkhang.jarvisai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    val _uiState : MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.OnUsernameChange -> {
                _uiState.value.username = event.username
            }
            is AuthEvent.OnPasswordChange -> {
                _uiState.value.password = event.password
            }
            is AuthEvent.OnLoginClick -> {
                // Handle login logic here
            }
            is AuthEvent.OnGoogleSignInClick -> {
                // Handle Google sign-in logic here
            }
        }
    }
}

sealed class AuthEvent {
    data class OnUsernameChange(val username: String) : AuthEvent()
    data class OnPasswordChange(val password: String) : AuthEvent()
    object OnLoginClick : AuthEvent()
    object OnGoogleSignInClick : AuthEvent()
}