package com.nguyenminhkhang.jarvisai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse
import com.nguyenminhkhang.jarvisai.domain.usecase.SignInUseCase
import com.nguyenminhkhang.jarvisai.domain.usecase.SignUpUseCase
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.LoginState
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    val _uiState : MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState

    val _signUpUiState : MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val signUpUiState: StateFlow<SignUpState> = _signUpUiState

    val _signInResult = MutableStateFlow<Result<SignInResponse>?>(null)
    val loginResult: StateFlow<Result<Any>?> = _signInResult

    val _signUpResult = MutableStateFlow<Result<SignUpResponse>?>(null)
    val signUpResult: StateFlow<Result<Any>?> = _signUpResult

    fun onSignInEvent(event: signInEvent) {
        when (event) {
            is signInEvent.OnUsernameChange -> {
                _uiState.value = _uiState.value.copy(username = event.username)
            }
            is signInEvent.OnPasswordChange -> {
                _uiState.value = _uiState.value.copy(password = event.password)
            }
            is signInEvent.OnSignInClick -> {
                viewModelScope.launch {
                    signInUseCase(
                        email = _uiState.value.username,
                        password = _uiState.value.password
                    ).collect {
                        _signInResult.value = it
                    }
                }
            }
            is signInEvent.OnGoogleSignInClick -> {
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
                viewModelScope.launch {
                    signUpUseCase(
                        email = _signUpUiState.value.username,
                        password = _signUpUiState.value.password,
                        verificationCallbackURL = ""
                    ).collect {
                        _signUpResult.value = it
                        // Handle sign-up result here
                    }
                }
            }
            is SignUpEvent.OnGoogleSignUpClick -> {
                // Handle Google sign-up logic here
            }
        }
    }
}

sealed class signInEvent {
    data class OnUsernameChange(val username: String) : signInEvent()
    data class OnPasswordChange(val password: String) : signInEvent()
    object OnSignInClick : signInEvent()
    object OnGoogleSignInClick : signInEvent()
}

sealed class SignUpEvent {
    data class OnUsernameChange(val username: String) : SignUpEvent()
    data class OnPasswordChange(val password: String) : SignUpEvent()
    data class OnConfirmPasswordChange(val confirmPassword: String) : SignUpEvent()
    object OnSignUpClick : SignUpEvent()
    object OnGoogleSignUpClick : SignUpEvent()
}