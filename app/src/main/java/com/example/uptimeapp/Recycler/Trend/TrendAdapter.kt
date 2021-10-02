package com.example.uptimeapp.Recycler.Trend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookList
import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookListItem
import com.example.uptimeapp.R


class TrendAdapter(): RecyclerView.Adapter<TrendHolder>() {


    private var result1 : BookList?=null

    constructor(responseDTO: BookList) : this() {
        this.result1=responseDTO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return TrendHolder(view)
    }

    override fun onBindViewHolder(holder: TrendHolder, position: Int) {
        val data: BookListItem = result1!![position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return result1!!.size
    }


}