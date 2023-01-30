package com.example.retrofit_parsing


import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {


    @GET("posts")
    fun getData() : Call<responseDataClass>         // Call - to know whether we got the response or not

}