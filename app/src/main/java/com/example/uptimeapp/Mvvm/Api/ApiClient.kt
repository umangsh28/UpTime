package com.example.uptimeapp.Mvvm.Api

import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {


    //https://run.mocky.io/v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd

    @GET("v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd")
    suspend fun getDataByApi():ResponseDTO

}