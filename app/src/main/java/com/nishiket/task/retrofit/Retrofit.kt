package com.nishiket.task.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Retrofit {
    @GET("/users")
    fun getUsers(): Call<List<Users>>
}