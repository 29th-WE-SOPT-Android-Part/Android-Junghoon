package com.example.soptassignment1.ui.signup

import com.example.soptassignment1.data.RequestSignupData
import com.example.soptassignment1.data.ResponseSignupData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignupService {
    @Headers("Content-Type:application/json")
    @POST("user/signup")
    fun postSignup(
        @Body body : RequestSignupData
    ) : Call<ResponseSignupData>
}