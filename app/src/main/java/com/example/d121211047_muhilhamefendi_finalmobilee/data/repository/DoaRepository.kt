package com.example.d121211047_muhilhamefendi_finalmobilee.data.repository

import com.example.d121211047_muhilhamefendi_finalmobilee.data.response.GetDoaResponse
import com.example.d121211047_muhilhamefendi_finalmobilee.data.source.remote.ApiService


class DoaRepository (private val apiService: ApiService){
    suspend fun getDoa(): GetDoaResponse {
        return apiService.getDoa()
    }
}