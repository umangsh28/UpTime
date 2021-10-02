package com.example.uptimeapp.Mvvm.Model2.ForYou


import com.google.gson.annotations.SerializedName

data class IndustryIdentifier(
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("type")
    val type: String
)