package com.nguyenminhkhang.jarvisai.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguyenminhkhang.jarvisai.R
import com.nguyenminhkhang.jarvisai.presentation.components.CustomButton
import com.nguyenminhkhang.jarvisai.presentation.components.CustomTextField
import com.nguyenminhkhang.jarvisai.presentation.components.SignInWithGoogle

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

@Composable
fun LoginScreen(modifier: Modifier) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background),
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
            CustomTextField(
                modifier = modifier,
                text = "",
                textFieldTitle = "Username",
                trailingIcon = null
            )
            CustomTextField(
                modifier = modifier,
                text = "",
                textFieldTitle = "Password",
                trailingIcon = painterResource(R.drawable.ic_eye_on)
            )
            CustomButton(
                modifier = modifier,
                buttonText = "Sign In",
                trailingIcon = null,
                onClick = { }
            )
            SignInWithGoogle(
                modifier = modifier,
                buttonText = "Sign in with Google",
                leadingIcon = painterResource(R.drawable.ic_google),
                onClick = { }
            )
        }
    }

}