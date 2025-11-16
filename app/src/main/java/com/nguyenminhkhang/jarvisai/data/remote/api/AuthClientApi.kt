package com.nguyenminhkhang.jarvisai.data.remote.api

import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthClientApi {

    @Headers(
        "X-Stack-Access-Type: client",
        "X-Stack-Project-Id: a914f06b-5e46-4966-8693-80e4b9f4f409",
        "X-Stack-Publishable-Client-Key: pck_tqsy29b64a585km2g4wnpc57ypjprzzdch8xzpq0xhayr",
        "Content-Type: application/json"
    )
    @POST("auth/password/sign-in")
    suspend fun signIn(
        @Body request: SignInRequest
    ): SignInResponse

    @Headers(
        "X-Stack-Access-Type: client",
        "X-Stack-Project-Id: a914f06b-5e46-4966-8693-80e4b9f4f409",
        "X-Stack-Publishable-Client-Key: pck_tqsy29b64a585km2g4wnpc57ypjprzzdch8xzpq0xhayr",
        "Content-Type: application/json"
    )
    @POST("auth/password/sign-up")
    suspend fun signUp(
        @Body request: SignUpRequest
    ): SignUpResponse
}