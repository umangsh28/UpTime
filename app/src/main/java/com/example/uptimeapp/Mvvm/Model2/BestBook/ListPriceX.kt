package com.example.uptimeapp.Mvvm.Model2.BestBook


import com.google.gson.annotations.SerializedName

data class ListPriceX(
    @SerializedName("amountInMicros")
    val amountInMicros: Int,
    @SerializedName("currencyCode")
    val currencyCode: String
)