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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguyenminhkhang.jarvisai.R
import com.nguyenminhkhang.jarvisai.presentation.components.CustomButton
import com.nguyenminhkhang.jarvisai.presentation.components.CustomTextField
import com.nguyenminhkhang.jarvisai.presentation.components.SignInWithGoogle
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.components.DividerOr
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.components.NoName

data class LoginState(
    var username: String = "",
    var password: String = "",
    var isLoading: Boolean = false,
    var errorMessage: String? = null
)

val spaceBetweenElements = 12.dp

@Composable
fun LoginScreen(uiState: LoginState) {
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
            Text("Wellcome", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Sign in to continue to your AI workspace", fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
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
                CustomTextField(
                    modifier = Modifier,
                    value = uiState.username,
                    textFieldTitle = "Username",
                    trailingIcon = null,
                    onValueChange = {uiState.username = it}
                )
                Spacer(Modifier.height(spaceBetweenElements))
                CustomTextField(
                    modifier = Modifier,
                    value = uiState.password,
                    textFieldTitle = "Password",
                    trailingIcon = painterResource(R.drawable.ic_eye_on),
                    onValueChange = {uiState.password = it},
                    isPassword = true
                )
                Spacer(Modifier.height(spaceBetweenElements))
                CustomButton(
                    modifier = Modifier,
                    buttonText = "Sign In",
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
                    fontSize = 12.sp,
                    onClick = {}
                )
            }
        }
    }
}