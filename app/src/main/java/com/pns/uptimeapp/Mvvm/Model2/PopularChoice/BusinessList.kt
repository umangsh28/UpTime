package com.pns.uptimeapp.Mvvm.Model2.PopularChoice


import com.google.gson.annotations.SerializedName

data class BusinessList(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)