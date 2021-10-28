package com.pns.uptimeapp.Recycler.PopularChoice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pns.uptimeapp.Mvvm.Model2.PopularChoice.BusinessList
import com.pns.uptimeapp.Mvvm.Model2.PopularChoice.Item
import com.pns.uptimeapp.Mvvm.OnClickListner.OnItemHome

import com.pns.uptimeapp.R

class BusinessAdapter() : RecyclerView.Adapter<BusinessHolder>() {

    private var result1 : BusinessList?=null
    private var clicklistener: OnItemHome?=null

    constructor(responseDTO: BusinessList,clicklistener:OnItemHome) : this() {
        this.result1=responseDTO
        this.clicklistener=clicklistener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return BusinessHolder(view,clicklistener!!)
    }

    override fun onBindViewHolder(holder: BusinessHolder, position: Int) {
        val data: Item = result1!!.items.get(position)
        holder.setData(data)
    }

    override fun getItemCount(): Int {
       return result1!!.items.size
    }


}