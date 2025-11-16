package com.nguyenminhkhang.jarvisai.domain.usecase

import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.repository.AuthRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    operator fun invoke(email: String, password: String) : Flow<Result<SignInResponse>> = flow{
        try {
            val request = SignInRequest(email, password)
            val result = repository.signIn(request)
            emit(result)
        } catch (e: IOException) {
            emit(Result.failure(e))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}