package com.example.uptimeapp.Mvvm.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object {

        var base="https://run.mocky.io/"

        fun getInstance():Retrofit {

               return Retrofit.Builder().baseUrl(base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        }
    }

}