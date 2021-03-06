package com.angel.uptimeapp.Recycler.ForYou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angel.uptimeapp.Mvvm.Model2.ForYou.Item

import com.angel.uptimeapp.Mvvm.Model2.ForYou.ThrillerList
import com.angel.uptimeapp.Mvvm.OnClickListner.OnItemHome
import com.angel.uptimeapp.R

class ThrillerAdapter() : RecyclerView.Adapter<ThrillerHolder>() {

    private var result1 : ThrillerList?=null
    private var clicklistener: OnItemHome?=null

    constructor(responseDTO: ThrillerList,clicklistener:OnItemHome) : this() {
        this.result1=responseDTO
        this.clicklistener=clicklistener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrillerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return ThrillerHolder(view,clicklistener!!)
    }

    override fun onBindViewHolder(holder: ThrillerHolder, position: Int) {
        val data: Item = result1!!.items.get(position)
        holder.setData(data,position)
    }

    override fun getItemCount(): Int {
      return result1!!.items.size
    }


}