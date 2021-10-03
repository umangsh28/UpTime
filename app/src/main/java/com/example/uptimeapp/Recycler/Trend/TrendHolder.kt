package com.example.uptimeapp.Recycler.Trend

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookListItem
import com.example.uptimeapp.Mvvm.OnClickListner.OnItemHome

import kotlinx.android.synthetic.main.itemdesign.view.*

class TrendHolder(private val itemVie : View,val listener:OnItemHome)
    : RecyclerView.ViewHolder(itemVie) {


    fun setData(data: BookListItem) {
        itemVie.apply{
            Glide.with(itemVie.ImgBook.context).load(data.thumbnailUrl)
                .into(itemVie.ImgBook)
            itemVie.Bauthor.text = data.title
            itemVie.Bname.text = data.authors[0].toString()
        }


        itemVie.setOnClickListener{
            listener.onTrendBook(data,adapterPosition)
        }

    }





}