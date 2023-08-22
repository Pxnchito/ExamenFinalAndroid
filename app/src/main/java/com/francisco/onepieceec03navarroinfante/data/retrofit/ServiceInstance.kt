package com.francisco.onepieceec03navarroinfante.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceInstance {
 // https://api.api-onepiece.com/arcs
    //https://run.mocky.io/v3/0a97cb61-2b6c-4d55-8f6c-8d0f52088a8d
    private val retrofit = Retrofit.Builder().
    baseUrl("https://api.api-onepiece.com/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getOnePieceService(): OnePieceService = retrofit.create(OnePieceService::class.java)
}