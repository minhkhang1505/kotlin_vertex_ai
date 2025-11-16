package com.nguyenminhkhang.jarvisai.data.remote.api

import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthClientApi {

    @POST("auth/password/sign-in")
    suspend fun signIn(
        @Body request: SignInRequest
    ): SignInResponse

    @POST("auth/password/sign-up")
    suspend fun signUp(
        @Body request: SignUpRequest
    ): SignUpResponse
}