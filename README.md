# Ktor-Android-Client

<table class=" wide" id="25207a75"><thead><tr class="ijRowHead" id="932ddc7e"><th id="a0696927"><p class="article__p child">Engine</p></th><th id="5bf792a2"><p class="article__p child">HTTP/2</p></th><th id="c9296819"><p class="article__p child">WebSockets</p></th></tr></thead><tbody><tr class="" id="492bb4b4"><td id="2ae3ec5a"><p class="article__p child">Apache</p></td><td id="b166d400"><p class="article__p child">❌</p></td><td id="8e0c17bd"><p class="article__p child">❌</p></td></tr><tr class="" id="5fae3327"><td id="f037e07a"><p class="article__p child">Java</p></td><td id="210ca8af"><p class="article__p child">✅</p></td><td id="c063eb9b"><p class="article__p child">❌</p></td></tr><tr class="" id="75d103b4"><td id="696c428f"><p class="article__p child">Jetty</p></td><td id="a400971e"><p class="article__p child">✅</p></td><td id="422868c"><p class="article__p child">❌</p></td></tr><tr class="" id="618e1cc9"><td id="9246e8ae"><p class="article__p child">CIO</p></td><td id="4c689174"><p class="article__p child">❌</p></td><td id="13930bf2"><p class="article__p child">✅</p></td></tr><tr class="" id="db6cb7f"><td id="a7a09e7d"><p class="article__p child">Android</p></td><td id="a297b1c0"><p class="article__p child">❌</p></td><td id="9a76f9d7"><p class="article__p child">❌</p></td></tr><tr class="" id="268ecee"><td id="444005f7"><p class="article__p child">OkHttp</p></td><td id="c0e00575"><p class="article__p child">✅</p></td><td id="b2140156"><p class="article__p child">✅</p></td></tr><tr class="" id="db8de8bb"><td id="427b406c"><p class="article__p child">Js</p></td><td id="eaf11c14"><p class="article__p child">✅</p></td><td id="ee9c8139"><p class="article__p child">✅</p></td></tr><tr class="" id="23b640f5"><td id="9e5ca3cb"><p class="article__p child">Darwin</p></td><td id="e5044d2a"><p class="article__p child">✅</p></td><td id="58d286e3"><p class="article__p child">✅</p></td></tr><tr class="" id="9b7dcb21"><td id="dd070023"><p class="article__p child">Curl</p></td><td id="9db2e97d"><p class="article__p child">✅</p></td><td id="a25f7970"><p class="article__p child">❌</p></td></tr></tbody></table>

## Request get,post,parallel request

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

## Content Negotable Response

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
       
       
