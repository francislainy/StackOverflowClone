package com.example.stackoverflowclone.network
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8081")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}
