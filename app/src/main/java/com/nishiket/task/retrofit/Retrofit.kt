package com.nishiket.task.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Retrofit {
    @GET("/users")
    fun getUsers(): Call<List<Users>>

    @POST("/auth/login")
    fun authUser(@Body userAndPassword: UserPassword): Call<Success>

    @FormUrlEncoded
    @POST("/forms/u/0/d/e/1FAIpQLSftugDGzXSLSnvZDO-LYoMzIEvEKyBQNDY9Ln0bLEWN69t1zw/formResponse")
    fun updateCounter(
        @Field("entry.700384962") name: String,
        @Field("entry.1767562699") counter: String
    ): Call<Success>
}