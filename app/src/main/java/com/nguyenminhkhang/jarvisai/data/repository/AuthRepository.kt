package com.nguyenminhkhang.jarvisai.data.repository

import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse

interface AuthRepository {
    suspend fun signIn(request: SignInRequest): Result<SignInResponse>
    suspend fun signUp(request: SignUpRequest): Result<SignUpResponse>
}