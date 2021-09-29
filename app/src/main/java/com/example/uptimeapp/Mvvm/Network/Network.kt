package com.example.uptimeapp.Mvvm.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Network {

    companion object {

        var base="https://itunes.apple.com/"

        fun getInstance():Retrofit {

               return Retrofit.Builder().baseUrl(base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        }
    }

}