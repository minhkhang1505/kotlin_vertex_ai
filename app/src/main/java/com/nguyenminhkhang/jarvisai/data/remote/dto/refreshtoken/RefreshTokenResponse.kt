package com.nguyenminhkhang.jarvisai.data.remote.dto.refreshtoken

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(
    @SerializedName("access_token")
    val accessToken: String,
)
