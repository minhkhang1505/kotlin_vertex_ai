package com.nguyenminhkhang.jarvisai.data.remote.dto.sign

data class SignInReaponse(
    val accessToken: String,
    val refreshToken: String,
    val userID: String
)
