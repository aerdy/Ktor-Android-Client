package com.example.ktorsample.net

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.kotlinx.serializer.*
import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.serialization.kotlinx.xml.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

object KtorClient {

    private val client = HttpClient(Android) {
//        defaultRequest {
//            header(AUTHORIZATION_HEADER, "BEARER $API_KEY")
//        }

        install(ContentNegotiation) {
            gson()
        }

        //or
        install(ContentNegotiation){
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }

        install(ContentNegotiation){
            xml()
        }

    }

    val getInstance = client
}