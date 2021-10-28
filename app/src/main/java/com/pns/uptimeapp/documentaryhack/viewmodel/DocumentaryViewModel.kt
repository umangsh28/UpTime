package com.pns.uptimeapp.documentaryhack.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pns.uptimeapp.documentaryhack.model.DocumentaryHackModel
import com.pns.uptimeapp.documentaryhack.repository.Repo

class DocumentaryViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<DocumentaryHackModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).data
    }

    fun geData(): MutableLiveData<ArrayList<DocumentaryHackModel>> {

        return data
    }
}