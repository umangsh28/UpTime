package com.pns.uptimeapp.bookhack.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pns.uptimeapp.bookhack.model.BookHackModel
import com.pns.uptimeapp.bookhack.repository.Repo

class BookViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<BookHackModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).data
    }

    fun geData(): MutableLiveData<ArrayList<BookHackModel>> {

        return data
    }
}