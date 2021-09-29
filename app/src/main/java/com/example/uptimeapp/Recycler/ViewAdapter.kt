package com.example.dummy.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummy.R
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Model.Result
import com.example.uptimeapp.Recycler.UViewHolder


class ViewAdapter(context: Context,var result1 :ResponseDTO): RecyclerView.Adapter<UViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return UViewHolder(view)
    }

    override fun onBindViewHolder(holder: UViewHolder, position: Int) {
        val data: Result = result1.results!!.get(position)
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return result1.results!!.size
    }


}