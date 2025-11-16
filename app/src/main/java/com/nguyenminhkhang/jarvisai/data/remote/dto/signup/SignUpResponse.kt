package com.nguyenminhkhang.jarvisai.data.remote.dto.signup

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user_id")
    val userID: String
)