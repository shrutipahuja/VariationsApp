package com.example.variationsapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://gitlab.box8.co.in/snippets/33/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface VariationsApiService {
    @GET("raw/")
    suspend fun getVariations(): VariationsDetail
}

object VariationsApi {
    val retrofitservice: VariationsApiService by lazy {
        retrofit.create(VariationsApiService::class.java)
    }
}