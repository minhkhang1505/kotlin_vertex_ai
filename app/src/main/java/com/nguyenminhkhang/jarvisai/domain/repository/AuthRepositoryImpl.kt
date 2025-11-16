package com.nguyenminhkhang.jarvisai.domain.repository

import com.nguyenminhkhang.jarvisai.data.remote.api.AuthClientApi
import com.nguyenminhkhang.jarvisai.data.remote.dto.auth.AuthResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.refreshtoken.RefreshTokenResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.sign.SignInResponse
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpRequest
import com.nguyenminhkhang.jarvisai.data.remote.dto.signup.SignUpResponse
import com.nguyenminhkhang.jarvisai.data.repository.AuthRepository
import org.jetbrains.annotations.Async
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
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

    override suspend fun signOut(): Result<AuthResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshToken(): Result<RefreshTokenResponse> {
        TODO("Not yet implemented")
    }
}