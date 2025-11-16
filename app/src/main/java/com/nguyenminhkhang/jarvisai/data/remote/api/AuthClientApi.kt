package com.nguyenminhkhang.jarvisai.data.remote.api

import com.nguyenminhkhang.jarvisai.data.remote.dto.auth.AuthResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.refreshtoken.RefreshTokenResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.HTTP
import retrofit2.http.Header
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

    @Headers(
        "X-Stack-Access-Type: client",
        "X-Stack-Project-Id: a914f06b-5e46-4966-8693-80e4b9f4f409",
        "X-Stack-Publishable-Client-Key: pck_tqsy29b64a585km2g4wnpc57ypjprzzdch8xzpq0xhayr",
    )
    @POST("auth/sessions/current/refresh")
    suspend fun refreshToken(
        @Header("X-Stack-Refresh-Token") refreshToken: String,
        @Body body:Unit =  Unit
    ): RefreshTokenResponse

    @Headers(
        "X-Stack-Access-Type: client",
        "X-Stack-Project-Id: a914f06b-5e46-4966-8693-80e4b9f4f409",
        "X-Stack-Publishable-Client-Key: pck_tqsy29b64a585km2g4wnpc57ypjprzzdch8xzpq0xhayr",
        "Content-Type: application/json"
    )
    @HTTP(method = "DELETE", path = "auth/sessions/current", hasBody = true)
    suspend fun signOut(
        @Header("Authorization") authorization: String,       // Bearer accessToken
        @Header("X-Stack-Refresh-Token") refreshToken: String,
        @Body body: Unit = Unit                                // JSON body rỗng {}
    ): AuthResponse
}