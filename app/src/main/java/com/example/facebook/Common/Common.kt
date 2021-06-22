package com.example.facebook.Common

import com.example.facebook.Interface.RetrofitService
import com.example.facebook.Retrofit.RetrofitClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Common {
    private val BASE_URL = "https://run.mocky.io/v3/"

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()


    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}