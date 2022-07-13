# Ktor-Android-Client


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
