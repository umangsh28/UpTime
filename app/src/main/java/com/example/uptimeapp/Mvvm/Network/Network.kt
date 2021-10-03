package com.example.uptimeapp.Mvvm.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object{
        private val httpLoggingInterceptor= HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)
        fun getretro(): Retrofit {

            var retrofit=Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()

            return retrofit


        }


        private val httpLoggingInterceptor1= HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)
        fun getGoogle(): Retrofit {

            var retrofit=Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor1).build())
                .build()

            return retrofit

        }




    }






}