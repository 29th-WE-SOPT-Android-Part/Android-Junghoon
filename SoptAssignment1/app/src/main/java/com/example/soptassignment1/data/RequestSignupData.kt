package com.example.soptassignment1.data

import com.google.gson.annotations.SerializedName

data class RequestSignupData(
    @SerializedName("email")
    val id: String,
    val name: String,
    val password: String
)
