package com.pns.uptimeapp.collection.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pns.uptimeapp.collection.model.CollectionsModel
import com.pns.uptimeapp.collection.repository.Repo

class CollectionsViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<CollectionsModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).data
    }

    fun geData(): MutableLiveData<ArrayList<CollectionsModel>> {

        return data
    }
}