package com.angel.uptimeapp.Recycler.BestBook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angel.uptimeapp.Mvvm.Model2.BestBook.FictionList
import com.angel.uptimeapp.Mvvm.Model2.BestBook.Item
import com.angel.uptimeapp.Mvvm.OnClickListner.OnItemHome
import com.angel.uptimeapp.R

class FictionAdapter() : RecyclerView.Adapter<FictionHolder>() {

    private var result1 : FictionList?=null
    private var clicklistener: OnItemHome?=null

    constructor(responseDTO: FictionList,clicklistener:OnItemHome) : this() {
        this.result1=responseDTO
        this.clicklistener=clicklistener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FictionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return FictionHolder(view,clicklistener!!)
    }

    override fun onBindViewHolder(holder: FictionHolder, position: Int) {
        val data: Item = result1!!.items[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
      return result1!!.items.size
    }
}