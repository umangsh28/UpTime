package com.example.uptimeapp.Recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uptimeapp.Mvvm.Model.Result
import kotlinx.android.synthetic.main.itemdesign.view.*

class UviewHolder(private val itemView : View)
    : RecyclerView.ViewHolder(itemView) {


    fun setData(data: Result) {
        itemView.apply {
            Glide.with(itemView.ImgBook.context).load(data.artworkUrl100)
                .into(itemView.ImgBook)
            itemView.Bname.text = data.trackName.toString()
            itemView.Bauthor.text = data.artistName.toString()
        }
    }




}