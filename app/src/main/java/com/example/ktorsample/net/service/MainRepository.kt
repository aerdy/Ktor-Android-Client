package com.example.ktorsample.net.service

import android.util.Log
import com.example.ktorsample.data.MovieResponse
import io.ktor.client.plugins.*
import timber.log.Timber
import java.io.IOException
import java.lang.Exception

object MainRepository {

    suspend fun search(): MovieResponse{
            //val response = YelpAppServicesImpl.search(term = term ?: "")
            val response = AppServicesImpl.search()
            Log.e("data",response.toString())
            return response
    }
}