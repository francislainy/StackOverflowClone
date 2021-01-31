package com.example.stackoverflowclone.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @GET("")
    fun getResponse(
        @Url fullUrl: String?
    ): Call<JsonObject>

    @POST("")
    fun postResponse(
        @Header("Authorization") authorization: String?,
        @Url fullUrl: String?,
        @Body jsonObject: JsonObject
    ): Call<JsonObject>

}
