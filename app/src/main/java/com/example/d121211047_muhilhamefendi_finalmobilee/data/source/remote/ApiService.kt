package com.example.d121211047_muhilhamefendi_finalmobilee.data.source.remote

import com.example.d121211047_muhilhamefendi_finalmobilee.data.response.GetDoaResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api")
    suspend fun getDoa(): GetDoaResponse
}
