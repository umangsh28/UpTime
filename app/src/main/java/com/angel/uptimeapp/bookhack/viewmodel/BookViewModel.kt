package com.angel.uptimeapp.bookhack.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angel.uptimeapp.bookhack.model.BookHackModel
import com.angel.uptimeapp.bookhack.repository.Repo

class BookViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<BookHackModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).data
    }

    fun geData(): MutableLiveData<ArrayList<BookHackModel>> {

        return data
    }
}