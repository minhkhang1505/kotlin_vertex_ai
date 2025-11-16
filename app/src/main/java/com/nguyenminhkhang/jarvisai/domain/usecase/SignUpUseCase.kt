package com.nguyenminhkhang.jarvisai.domain.usecase

import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse
import com.nguyenminhkhang.jarvisai.data.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SignUpUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke(
        email: String,
        password: String,
        verificationCallbackURL: String
    ) : Flow<Result<SignUpResponse>> = flow{
        try {
            val request = SignUpRequest(
                email = email,
                password = password,
                verificationCallbackURL = verificationCallbackURL
            )
            val result = repository.signUp(request)
            emit(result)
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}