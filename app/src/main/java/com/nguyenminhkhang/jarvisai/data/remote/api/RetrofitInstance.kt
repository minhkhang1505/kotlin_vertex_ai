package com.nguyenminhkhang.jarvisai.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://auth-api.dev.jarvis.cx/api/v1/"

    val api : AuthClientApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthClientApi::class.java)
    }
}