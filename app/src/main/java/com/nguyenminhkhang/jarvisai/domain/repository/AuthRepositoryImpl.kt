package com.nguyenminhkhang.jarvisai.domain.repository

import com.nguyenminhkhang.jarvisai.data.remote.api.AuthClientApi
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse
import com.nguyenminhkhang.jarvisai.data.repository.AuthRepository
import java.io.IOException

class AuthRepositoryImpl(
    private val api: AuthClientApi
) : AuthRepository {
    override suspend fun signIn(request: SignInRequest): Result<SignInResponse> {
        return try {
            val response = api.signIn(request)
            Result.success(response)
        } catch (e: IOException) {
            Result.failure(e)
        }
        catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUp(request: SignUpRequest): Result<SignUpResponse> {
        return try {
            val response = api.signUp(request)
            Result.success(response)
        }catch(e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)}
    }
}