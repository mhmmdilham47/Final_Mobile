package com.example.d121211047_muhilhamefendi_finalmobilee.data

import com.example.d121211047_muhilhamefendi_finalmobilee.data.repository.DoaRepository
import com.example.d121211047_muhilhamefendi_finalmobilee.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val doaRepository: DoaRepository
}

class DefaultAppContainer: AppContainer {
    private val BASE_URL = "https://doa-doa-api-ahmadramadhan.fly.dev/"

    val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val doaRepository: DoaRepository
        get() = DoaRepository(retrofitService)

}