package com.nishiket.task.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private const val BASE_URL_POST = "https://fakestoreapi.com/"
    private const val BASE_URL_COUNTER = "https://docs.google.com/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun getInstancePost(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL_POST)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun getInstanceCounter(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL_COUNTER)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}