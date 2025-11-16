package com.nguyenminhkhang.jarvisai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.LoginState
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    val _uiState : MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState

    val _signUpUiState : MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val signUpUiState: StateFlow<SignUpState> = _signUpUiState

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnUsernameChange -> {
                _uiState.value = _uiState.value.copy(username = event.username)
            }
            is LoginEvent.OnPasswordChange -> {
                _uiState.value = _uiState.value.copy(password = event.password)
            }
            is LoginEvent.OnLoginClick -> {
                // Handle login logic here
            }
            is LoginEvent.OnGoogleSignInClick -> {
                // Handle Google sign-in logic here
            }
        }
    }

    fun onSignUpEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.OnUsernameChange -> {
                _signUpUiState.value = _signUpUiState.value.copy(username = event.username)
            }
            is SignUpEvent.OnPasswordChange -> {
                _signUpUiState.value = _signUpUiState.value.copy(password = event.password)
            }
            is SignUpEvent.OnConfirmPasswordChange -> {
                _signUpUiState.value = _signUpUiState.value.copy(confirmPassword = event.confirmPassword)
            }
            is SignUpEvent.OnSignUpClick -> {
                // Handle sign-up logic here
            }
            is SignUpEvent.OnGoogleSignUpClick -> {
                // Handle Google sign-up logic here
            }
        }
    }
}

sealed class LoginEvent {
    data class OnUsernameChange(val username: String) : LoginEvent()
    data class OnPasswordChange(val password: String) : LoginEvent()
    object OnLoginClick : LoginEvent()
    object OnGoogleSignInClick : LoginEvent()
}

sealed class SignUpEvent {
    data class OnUsernameChange(val username: String) : SignUpEvent()
    data class OnPasswordChange(val password: String) : SignUpEvent()
    data class OnConfirmPasswordChange(val confirmPassword: String) : SignUpEvent()
    object OnSignUpClick : SignUpEvent()
    object OnGoogleSignUpClick : SignUpEvent()
}