package com.angel.uptimeapp.Mvvm.Model2.ForYou


import com.google.gson.annotations.SerializedName

data class ThrillerList(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)