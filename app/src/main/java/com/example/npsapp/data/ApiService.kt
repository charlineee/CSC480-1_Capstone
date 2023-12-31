package com.example.npsapp.data

import com.example.npsapp.models.ParksResponse
import com.example.npsapp.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/parks")
    suspend fun getParks(
        @Query("stateCode") stateCode: String,
        @Query("q") activityCode: String,
        @Query("api_key") apiKey: String
    ): ParksResponse
    companion object {
        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}