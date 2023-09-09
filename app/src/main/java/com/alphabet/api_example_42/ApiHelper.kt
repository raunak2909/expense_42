package com.alphabet.api_example_42

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiHelper {


    companion object {

        //val BASE_URL = "https://dummyjson.com/"

        val BASE_URL = "https://api.pexels.com/v1/"

        fun create(): ApiHelper {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiHelper::class.java)
        }

    }

   /* @GET("products")
    abstract fun getProducts(): Call<DataModel>*/


    //@Headers("Authorization:nXWH9BLpCYtVtyjDTbJB3Hf20uneSxZcYisVLVmNDV4PamGm6EeVDgZm")
    @GET("search")
    abstract fun searchWallpaper(
        @Header("Authorization") auth: String,
        @Query("query") searchQuery: String): Call<PhotoDataModel>

}