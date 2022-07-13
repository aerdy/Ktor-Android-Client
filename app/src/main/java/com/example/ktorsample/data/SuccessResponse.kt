package com.example.ktorsample.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class SuccessResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: Any,
    @SerializedName("status")
    val status: String
) {
    @Keep
    class Data
}