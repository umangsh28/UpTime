package com.example.dummy.Mvvm.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uptimeapp.Mvvm.Api.ApiClient
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Network.Network

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UviewModel :ViewModel() {


    var dataByView: MutableLiveData<ResponseDTO>

    val dataerror= MutableLiveData<List<String>>()



    init {
        dataByView= MutableLiveData()
    }

    fun newdata(): MutableLiveData<ResponseDTO>{
        return dataByView
    }

    fun MakeAPI(){
        val retro=Network.getInstance()
        val rservice=retro.create(ApiClient::class.java)
        val calling=rservice.getDataByApi("English")
        calling.enqueue(object :Call<ResponseDTO>, retrofit2.Callback<ResponseDTO> {
            override fun onResponse(
                call: Call<ResponseDTO>,
                response: Response<ResponseDTO>
            ) {
                dataByView.postValue(response.body())
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                dataByView.postValue(null)
                Log.d("TAG",t.message.toString())
            }

            override fun clone(): Call<ResponseDTO> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<ResponseDTO> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<ResponseDTO>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }

        })
    }


}