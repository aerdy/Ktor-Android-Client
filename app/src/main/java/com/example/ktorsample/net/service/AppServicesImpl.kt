package com.example.ktorsample.net.service

import android.content.Context
import com.example.ktorsample.data.MovieResponse
import com.example.ktorsample.data.SuccessResponse
import com.example.ktorsample.data.param.PostMovie
import com.example.ktorsample.net.Endpoint
import com.example.ktorsample.net.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

object AppServicesImpl : AppServices {
    private val httpClient by lazy { KtorClient.getInstance }

    override suspend fun getMovie(): MovieResponse {
        return httpClient.get(Endpoint().movie).body()
    }

    override suspend fun postMovie(): SuccessResponse {
        val responseData:SuccessResponse = httpClient.post(Endpoint().movie){
            setBody(PostMovie("123","123"))
        }.body()
        return responseData
    }

    override suspend fun parallelRequest(context: CoroutineContext) {
        val req = CoroutineScope(context)
        var oneContext: SuccessResponse? = null
        var twoContext:SuccessResponse? = null
        req.async{
            oneContext = httpClient.get(Endpoint().movie).body()
        }.await()

        req.async {
            twoContext = httpClient.get(Endpoint().movie).body()
        }.await()
    }


}