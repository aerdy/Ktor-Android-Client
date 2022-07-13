package com.example.ktorsample.net.service

import android.content.Context
import com.example.ktorsample.data.MovieResponse
import com.example.ktorsample.data.SuccessResponse
import kotlin.coroutines.CoroutineContext

interface AppServices {
    suspend fun getMovie(): MovieResponse

    suspend fun postMovie():SuccessResponse

    suspend fun parallelRequest(context: CoroutineContext)
}