package com.angel.uptimeapp.Mvvm.Model2.ForYou


import com.google.gson.annotations.SerializedName

data class Epub(
    @SerializedName("acsTokenLink")
    val acsTokenLink: String,
    @SerializedName("isAvailable")
    val isAvailable: Boolean
)