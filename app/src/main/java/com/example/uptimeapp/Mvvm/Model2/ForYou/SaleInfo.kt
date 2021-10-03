package com.example.uptimeapp.Mvvm.Model2.ForYou


import com.google.gson.annotations.SerializedName

data class SaleInfo(
    @SerializedName("buyLink")
    val buyLink: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("isEbook")
    val isEbook: Boolean,

    @SerializedName("offers")
    val offers: List<Offer>,

)