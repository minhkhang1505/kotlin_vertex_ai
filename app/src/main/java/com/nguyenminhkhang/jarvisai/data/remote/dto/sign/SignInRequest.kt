package com.nguyenminhkhang.jarvisai.data.remote.dto.sign

import com.google.gson.annotations.SerializedName

data class SignInRequest (
    val email: String,
    val password: String
)
