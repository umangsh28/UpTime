package com.example.uptimeapp.Mvvm.Repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.uptimeapp.Mvvm.Api.ApiClient
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Network.Network

class Urepositary(val apiClient: ApiClient) {



    fun getDataByRepo(term : String)=apiClient.getDataByApi(term)


}