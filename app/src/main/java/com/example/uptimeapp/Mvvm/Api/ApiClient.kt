package com.example.uptimeapp.Mvvm.Api

import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {


    //https://itunes.apple.com/search?term=%22YOUR

    @GET("v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd")
    suspend fun getDataByApi(@Query("term") term :String):ResponseDTO

}