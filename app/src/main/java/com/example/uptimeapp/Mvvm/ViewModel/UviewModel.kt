package com.example.dummy.Mvvm.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.uptimeapp.Mvvm.Api.ApiClient
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Network.Network
import com.example.uptimeapp.Mvvm.Repo.Urepositary
import kotlinx.coroutines.Dispatchers

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UviewModel(var urepositary: Urepositary):ViewModel() {
    fun ApiCalling(term:String): LiveData<ResponseDTO> {

        val livedata= liveData<ResponseDTO>(Dispatchers.IO){
            val resultfromViewModel=urepositary.MakeAPICall(term)
            emit(resultfromViewModel)
        }
        return livedata
    }

}