package com.pns.uptimeapp.Mvvm.Model2.BestBook


import com.google.gson.annotations.SerializedName

data class RetailPriceX(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currencyCode")
    val currencyCode: String
)