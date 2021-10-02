package com.example.uptimeapp.collection.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uptimeapp.collection.model.CollectionsModel
import com.example.uptimeapp.collection.repository.Repo

class CollectionsViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<CollectionsModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).getData()
    }

    fun geData(): MutableLiveData<ArrayList<CollectionsModel>> {

        return data
    }
}