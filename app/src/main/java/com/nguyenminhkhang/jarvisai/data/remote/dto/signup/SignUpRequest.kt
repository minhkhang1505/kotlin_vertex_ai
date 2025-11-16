package com.nguyenminhkhang.jarvisai.data.remote.dto.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    val email: String,
    val password: String,

    @SerializedName("verification_callback_url")
    val verificationCallbackURL: String
)
