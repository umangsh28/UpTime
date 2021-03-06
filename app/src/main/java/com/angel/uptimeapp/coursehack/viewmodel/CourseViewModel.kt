package com.angel.uptimeapp.coursehack.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angel.uptimeapp.coursehack.model.CourseHackModel
import com.angel.uptimeapp.coursehack.repository.Repo

class CourseViewModel : ViewModel() {

    lateinit var data: MutableLiveData<ArrayList<CourseHackModel>>

    fun init(context: Context) {

        data = Repo.getInstance(context).data
    }

    fun geData(): MutableLiveData<ArrayList<CourseHackModel>> {

        return data
    }
}