package com.nguyenminhkhang.jarvisai.presentation.viewmodel

import android.util.Log
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
    val _signInUiState : MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val signInState: StateFlow<LoginState> = _signInUiState

    val _signUpUiState : MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val signUpUiState: StateFlow<SignUpState> = _signUpUiState

    val _signInResult = MutableStateFlow<Result<SignInResponse>?>(null)
    val signInResult: StateFlow<Result<Any>?> = _signInResult

    val _signUpResult = MutableStateFlow<Result<SignUpResponse>?>(null)
    val signUpResult: StateFlow<Result<Any>?> = _signUpResult

    private fun validator(
        signInState: LoginState?,
        signUpState: SignUpState?,
    ): Boolean {
        if (signInState != null) {
            val username = signInState.email ?: ""
            val password = signInState.password ?: ""
            if (username.isEmpty() || password.isEmpty()) {
                Log.d("AuthViewModel", "validator: Username or password is empty")
                _signInUiState.value.errorMessage = "Username and password must not be empty"
                return false
            }
        }
        else if (signUpState != null) {
            val username = signUpState.username ?: ""
            val password = signUpState.password ?: ""
            val confirmPassword = signUpState.confirmPassword ?: ""
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Log.d("AuthViewModel", "validator: Username, password or confirm password is empty")
                _signUpUiState.value.errorMessage = "Username, password and confirm password must not be empty"
                return false
            }
            if (password != confirmPassword) {
                Log.d("AuthViewModel", "validator: Password and confirm password do not match")
                _signUpUiState.value.errorMessage = "Password and confirm password do not match"
                return false
            }
        }
        return true
    }

    fun onSignInEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.OnUsernameChange -> {
                _signInUiState.value = _signInUiState.value.copy(email = event.username)
            }
            is SignInEvent.OnPasswordChange -> {
                _signInUiState.value = _signInUiState.value.copy(password = event.password)
            }
            is SignInEvent.OnSignInClick -> {
                if (!validator(_signInUiState.value, null)) {
                    return
                }
                viewModelScope.launch {
                    signInUseCase(
                        email = _signInUiState.value.email,
                        password = _signInUiState.value.password
                    ).collect {result ->
                        Log.d("AuthViewModel", "onSignUpEvent: Sign-up result: $result")
                        _signInResult.value = result
                    }
                }
            }
            is SignInEvent.OnGoogleSignInClick -> {
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
                if(!validator(null, _signUpUiState.value)) {
                    return
                }
                viewModelScope.launch {
                    signUpUseCase(
                        email = _signUpUiState.value.username,
                        password = _signUpUiState.value.password,
                        verificationCallbackURL = ""
                    ).collect {result ->
                        Log.d("AuthViewModel", "onSignUpEvent: Sign-up result: $result")
                        _signUpResult.value = result
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

sealed class SignInEvent {
    data class OnUsernameChange(val username: String) : SignInEvent()
    data class OnPasswordChange(val password: String) : SignInEvent()
    object OnSignInClick : SignInEvent()
    object OnGoogleSignInClick : SignInEvent()

}

sealed class SignUpEvent {
    data class OnUsernameChange(val username: String) : SignUpEvent()
    data class OnPasswordChange(val password: String) : SignUpEvent()
    data class OnConfirmPasswordChange(val confirmPassword: String) : SignUpEvent()
    object OnSignUpClick : SignUpEvent()
    object OnGoogleSignUpClick : SignUpEvent()
}