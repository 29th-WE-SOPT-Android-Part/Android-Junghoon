package com.example.soptassignment1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService : LoginService = retrofit.create(LoginService::class.java)
    val signupService : SignupService = retrofit.create(SignupService::class.java)
}