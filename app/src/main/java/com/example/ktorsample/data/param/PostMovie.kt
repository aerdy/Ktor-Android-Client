package com.example.ktorsample.data.param


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PostMovie(
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String
)