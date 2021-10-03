package com.example.uptimeapp.Mvvm.Model2.ForYou


import com.google.gson.annotations.SerializedName

data class RetailPriceX(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("currencyCode")
    val currencyCode: String
)