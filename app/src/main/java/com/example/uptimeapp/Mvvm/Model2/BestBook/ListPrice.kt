package com.example.uptimeapp.Mvvm.Model2.BestBook


import com.google.gson.annotations.SerializedName

data class ListPrice(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currencyCode")
    val currencyCode: String
)