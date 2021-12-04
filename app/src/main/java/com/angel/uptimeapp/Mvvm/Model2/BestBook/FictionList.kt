package com.angel.uptimeapp.Mvvm.Model2.BestBook


import com.google.gson.annotations.SerializedName

data class FictionList(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)