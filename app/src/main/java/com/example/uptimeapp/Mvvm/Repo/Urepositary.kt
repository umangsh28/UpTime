package com.example.uptimeapp.Mvvm.Repo

import com.example.uptimeapp.Mvvm.Api.ApiClient
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Network.Network

class Urepositary() {
//    val retro = Network.getInstance().create(ApiClient::class.java)

    suspend fun MakeAPICall(term:String): ResponseDTO {

        val retro = Network.getInstance().create(ApiClient::class.java)
        val appi = retro.getDataByApi(term)
        return appi
    }



}