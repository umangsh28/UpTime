package com.pns.uptimeapp.Recycler.ForYou

import android.net.Uri
import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pns.uptimeapp.Mvvm.Model2.ForYou.Item
import com.pns.uptimeapp.Mvvm.OnClickListner.OnItemHome

import kotlinx.android.synthetic.main.itemdesign.view.*

class ThrillerHolder(var itemVie: View,val listener: OnItemHome) : RecyclerView.ViewHolder(itemVie) {


    fun setData(data: Item, pos:Int) {
        itemVie.apply {


            var mUri: Uri = data.volumeInfo.imageLinks.thumbnail.toUri()


            Glide.with(itemVie.ImgBook.context).load(mUri)
                .into(itemVie.ImgBook)


            itemVie.Bauthor.text = data.volumeInfo.title.toString()


            itemVie.Bname.text = data.volumeInfo.authors[0].toString()


        }

        itemVie.setOnClickListener{
            listener.onThrillerBook(data,adapterPosition)
        }

    }

}



