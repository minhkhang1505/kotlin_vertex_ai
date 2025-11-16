package com.nguyenminhkhang.jarvisai

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.LoginScreen
import com.nguyenminhkhang.jarvisai.presentation.screens.auth.LoginState
import com.nguyenminhkhang.jarvisai.ui.theme.JarvisAITheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JarvisAITheme(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = false
            ) {
                LoginScreen()
            }
        }
    }
}

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}