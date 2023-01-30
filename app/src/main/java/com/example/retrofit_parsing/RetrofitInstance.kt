package com.example.retrofit_parsing

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {               // Create retrofit object

    private val retrofit by  lazy{
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy{           //  Connect retrofit to Api interface
        retrofit.create(ApiInterface::class.java)
    }
}