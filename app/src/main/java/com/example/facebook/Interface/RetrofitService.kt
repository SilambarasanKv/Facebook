package com.example.facebook.Interface

import com.example.facebook.Model.Feed
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("e27bf00e-9b1d-4e50-9cb3-f0806cfef566")
    fun getAllData(): Call<List<Feed>>
}