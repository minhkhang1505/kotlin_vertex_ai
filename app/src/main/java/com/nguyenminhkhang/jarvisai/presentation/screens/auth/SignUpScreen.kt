package com.nguyenminhkhang.jarvisai.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.nguyenminhkhang.jarvisai.R
import com.nguyenminhkhang.jarvisai.presentation.components.CustomButton
import com.nguyenminhkhang.jarvisai.presentation.components.CustomTextField
import com.nguyenminhkhang.jarvisai.presentation.components.SignInWithGoogle
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.components.DividerOr
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.components.NoName
import com.nguyenminhkhang.jarvisai.presentation.viewmodel.LoginEvent
import com.nguyenminhkhang.jarvisai.presentation.viewmodel.AuthViewModel
import com.nguyenminhkhang.jarvisai.presentation.viewmodel.SignUpEvent

data class SignUpState(
    var username: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var isLoading: Boolean = false,
    var errorMessage: String? = null
)

@Composable
fun SignUpScreen(viewModel : AuthViewModel = hiltViewModel()) {
    val uiState = viewModel.signUpUiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_ai_star), contentDescription = "App Logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.CenterHorizontally).size(60.dp)
            )
            Text("Sign Up", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text("Join thousand of AI enthusiasts today", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.7f))
        }
        Spacer(Modifier.height(20.dp))
        Surface (
            shape = RoundedCornerShape(30.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            shadowElevation = 4.dp
        ) {
            Column (
                modifier = Modifier.clip(RoundedCornerShape(30.dp))
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(16.dp),
            ) {
                Text("Enter your info to create new account", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(spaceBetweenElements))
                CustomTextField(
                    modifier = Modifier,
                    value = uiState.value.username,
                    textFieldTitle = "Username",
                    trailingIcon = null,
                    onValueChange = {viewModel.onSignUpEvent(SignUpEvent.OnUsernameChange(it))},
                )
                Spacer(Modifier.height(spaceBetweenElements))
                CustomTextField(
                    modifier = Modifier,
                    value = uiState.value.password,
                    textFieldTitle = "Password",
                    trailingIcon = painterResource(R.drawable.ic_eye_on),
                    onValueChange = {viewModel.onSignUpEvent(SignUpEvent.OnPasswordChange(it))},
                    isPassword = true
                )
                Spacer(Modifier.height(spaceBetweenElements))
                CustomTextField(
                    modifier = Modifier,
                    value = uiState.value.confirmPassword,
                    textFieldTitle = "Confirm Password",
                    trailingIcon = painterResource(R.drawable.ic_eye_on),
                    onValueChange = {viewModel.onSignUpEvent(SignUpEvent.OnConfirmPasswordChange(it))},
                    isPassword = true
                )
                Spacer(Modifier.height(spaceBetweenElements + 12.dp))
                CustomButton(
                    modifier = Modifier,
                    buttonText = "Create Account",
                    trailingIcon = null,
                    onClick = { }
                )
                Spacer(Modifier.height(spaceBetweenElements + 10.dp))
                DividerOr(modifier = Modifier.padding(horizontal = 60.dp))
                Spacer(Modifier.height(spaceBetweenElements + 10.dp))
                SignInWithGoogle(
                    modifier = Modifier,
                    buttonText = "Sign in with Google",
                    leadingIcon = painterResource(R.drawable.ic_google),
                    onClick = { }
                )
                Spacer(Modifier.height(spaceBetweenElements))
                NoName(
                    description = "You already have an account? ",
                    fontSize = 12.sp,
                    onClick = {},
                    buttonName = "Sign In"
                )
            }
        }
    }
}