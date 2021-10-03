package com.example.uptimeapp.bookhack.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uptimeapp.bookhack.model.BookHackModel
import com.example.uptimeapp.bookhack.repository.Repo

class BookViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<BookHackModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).getData()
    }

    fun geData(): MutableLiveData<ArrayList<BookHackModel>> {

        return data
    }
}