package com.nguyenminhkhang.jarvisai.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguyenminhkhang.jarvisai.R
import com.nguyenminhkhang.jarvisai.presentation.components.CustomButton
import com.nguyenminhkhang.jarvisai.presentation.components.CustomTextField
import com.nguyenminhkhang.jarvisai.presentation.components.SignInWithGoogle
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.components.DividerOr
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.components.NoName
import com.nguyenminhkhang.jarvisai.ui.theme.JarvisAITheme

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

val spaceBetweenElements = 12.dp

@Composable
fun LoginScreen() {
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
                    text = "",
                    textFieldTitle = "Username",
                    trailingIcon = null
                )
                Spacer(Modifier.height(spaceBetweenElements))
                CustomTextField(
                    modifier = Modifier,
                    text = "",
                    textFieldTitle = "Password",
                    trailingIcon = painterResource(R.drawable.ic_eye_on)
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