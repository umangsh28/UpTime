package com.example.uptimeapp.Recycler.BestBook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uptimeapp.Mvvm.Model2.BestBook.FictionList
import com.example.uptimeapp.Mvvm.Model2.BestBook.Item
import com.example.uptimeapp.R

class FictionAdapter() : RecyclerView.Adapter<FictionHolder>() {

    private var result1 : FictionList?=null

    constructor(responseDTO: FictionList) : this() {
        this.result1=responseDTO
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FictionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return FictionHolder(view)
    }

    override fun onBindViewHolder(holder: FictionHolder, position: Int) {
        val data: Item = result1!!.items[position]
        holder.setData(data,position)
    }

    override fun getItemCount(): Int {
      return result1!!.items.size
    }
}