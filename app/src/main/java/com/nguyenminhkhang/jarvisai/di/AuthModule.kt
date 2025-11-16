package com.nguyenminhkhang.jarvisai.di

import com.nguyenminhkhang.jarvisai.data.repository.AuthRepository
import com.nguyenminhkhang.jarvisai.domain.repository.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository
}