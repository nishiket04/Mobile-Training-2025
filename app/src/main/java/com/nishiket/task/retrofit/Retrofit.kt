package com.nishiket.task.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Retrofit {
    @GET("/users")
    fun getUsers(): Call<List<Users>>
    @POST("/auth/login")
    fun authUser(@Body userAndPassword:UserPassword):Call<Success>
}