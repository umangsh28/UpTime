package com.example.uptimeapp.Mvvm.Repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.bumptech.glide.load.engine.Resource
import com.example.uptimeapp.Mvvm.Api.ApiClient
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Network.Network
import com.example.uptimeapp.Mvvm.Network.Network1

class Urepositary() {







//

    suspend fun MakeAPICall():ResponseDTO{

               val retro = Network1.getInstance().create(ApiClient::class.java)
               val appi = retro.getDataByApi()
               return appi
    }





}