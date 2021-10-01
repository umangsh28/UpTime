package com.example.dummy.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Model.Result
import com.example.uptimeapp.R
import com.example.uptimeapp.Recycler.UviewHolder


class ViewAdapterr(var context: Context,
                   var result1 : ResponseDTO)
    : RecyclerView.Adapter<UviewHolder>() {

//    fun setdata(responseDTO:ResponseDTO){
//        this.result1=responseDTO
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdesign, parent, false)
        return UviewHolder(view)
    }

    override fun onBindViewHolder(holder: UviewHolder, position: Int) {
        val data: Result = result1.results!!.get(position)
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return result1.results!!.size
    }
}