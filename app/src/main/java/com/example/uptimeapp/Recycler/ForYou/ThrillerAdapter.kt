package com.example.uptimeapp.Recycler.ForYou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.uptimeapp.Mvvm.Model2.BestBook.FictionList
import com.example.uptimeapp.Mvvm.Model2.ForYou.Item

import com.example.uptimeapp.Mvvm.Model2.ForYou.ThrillerList
import com.example.uptimeapp.R
import com.example.uptimeapp.Recycler.BestBook.FictionHolder

class ThrillerAdapter() : RecyclerView.Adapter<ThrillerHolder>() {

    private var result1 : ThrillerList?=null

    constructor(responseDTO: ThrillerList) : this() {
        this.result1=responseDTO
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrillerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return ThrillerHolder(view)
    }

    override fun onBindViewHolder(holder: ThrillerHolder, position: Int) {
        val data: Item = result1!!.items.get(position)
        holder.setData(data,position)
    }

    override fun getItemCount(): Int {
      return result1!!.items.size
    }


}