package com.example.uptimeapp.Mvvm.Model2.ForYou


import com.google.gson.annotations.SerializedName

data class ListPrice(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("currencyCode")
    val currencyCode: String
)