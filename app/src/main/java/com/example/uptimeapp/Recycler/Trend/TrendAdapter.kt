package com.example.uptimeapp.Recycler.Trend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookList
import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookListItem
import com.example.uptimeapp.Mvvm.OnClickListner.OnItemHome
import com.example.uptimeapp.R
import com.example.uptimeapp.fragments.HomeFragment


class TrendAdapter(): RecyclerView.Adapter<TrendHolder>() {


    private var result1 : BookList?=null
    private var clicklistener: OnItemHome?=null

    constructor(responseDTO: BookList,clicklistener:OnItemHome) : this() {
        this.result1=responseDTO
        this.clicklistener=clicklistener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return TrendHolder(view,clicklistener!!)
    }

    override fun onBindViewHolder(holder: TrendHolder, position: Int) {
        val data: BookListItem = result1!![position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return result1!!.size
    }


}