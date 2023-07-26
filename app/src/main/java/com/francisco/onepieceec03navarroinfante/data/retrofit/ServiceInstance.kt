package com.francisco.onepieceec03navarroinfante.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceInstance {
 // https://api.api-onepiece.com/arcs
    private val retrofit = Retrofit.Builder().
    baseUrl("\n" +
            "https://api.api-onepiece.com/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getOnePieceService(): OnePieceService = retrofit.create(OnePieceService::class.java)
}