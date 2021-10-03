package com.example.uptimeapp.coursehack.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uptimeapp.coursehack.model.CourseHackModel
import com.example.uptimeapp.coursehack.repository.Repo

class CourseViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<CourseHackModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).getData()
    }

    fun geData(): MutableLiveData<ArrayList<CourseHackModel>> {

        return data
    }
}