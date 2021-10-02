package com.example.uptimeapp.Recycler.PopularChoice

import android.net.Uri
import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uptimeapp.Mvvm.Model2.PopularChoice.Item

import kotlinx.android.synthetic.main.itemdesign.view.*

class BusinessHolder(var itemVie: View) : RecyclerView.ViewHolder(itemVie) {


    fun setData(data: Item) {

        var mUri : Uri = data.volumeInfo.imageLinks.thumbnail.toUri()

        itemVie.apply{



            Glide.with(itemVie.ImgBook.context).load(mUri)
                .into(itemVie.ImgBook)
            itemVie.Bauthor.text = data.volumeInfo.title.toString()
            itemVie.Bname.text = data.volumeInfo.authors.toString()

        }

    }




}