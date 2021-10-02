package com.example.uptimeapp.Mvvm.API


import com.example.uptimeapp.Mvvm.Model2.PopularChoice.BusinessList
import com.example.uptimeapp.Mvvm.Model2.BestBook.FictionList
import com.example.uptimeapp.Mvvm.Model2.ForYou.ThrillerList
import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookList
import retrofit2.http.GET
import retrofit2.Call

interface APIClient {
    //https://run.mocky.io/v3/ed7476a8-a67f-45b9-98e8-f7705df35a16

    @GET("v3/ed7476a8-a67f-45b9-98e8-f7705df35a16")
    fun getBook(): Call<BookList>

//    //https://run.mocky.io/v3/2d48973a-5740-4c69-9dc5-547a04b34152
//    @GET("v3/2d48973a-5740-4c69-9dc5-547a04b34152")
//    fun getfiction(): Call<FictionList>

//    //https://run.mocky.io/v3/ed7476a8-a67f-45b9-98e8-f7705df35a16
//    @GET("v3/ed7476a8-a67f-45b9-98e8-f7705df35a16")
//    fun getBusiness(): Call<BusinessList>

    //https://www.googleapis.com/books/v1/volumes?q=fiction

    @GET("books/v1/volumes?q=fiction")
    fun getfiction(): Call<FictionList>


    //https://www.googleapis.com/books/v1/volumes?q=Novel

    @GET("books/v1/volumes?q=Novel")
    fun getBusiness(): Call<BusinessList>

    //https://www.googleapis.com/books/v1/volumes?q=thriller

    @GET("books/v1/volumes?q=thriller")
    fun getThriller(): Call<ThrillerList>










}