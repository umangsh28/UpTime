package com.pns.uptimeapp.collection.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pns.uptimeapp.R
import com.pns.uptimeapp.collection.model.CollectionsModel
import kotlinx.android.synthetic.main.collection_row_item.view.*

class CollectionsAdapter(private val list: MutableList<CollectionsModel>) : RecyclerView.Adapter<CollectionsAdapter.CollectionsViewHolder>() {

    class CollectionsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        fun setData(model: CollectionsModel){

            itemView.apply {

                Glide.with(img)
                    .load(model.imgUrl)
                    .into(img)
                desc.text = model.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsViewHolder {
        return CollectionsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.collection_row_item, parent, false))
    }

    override fun onBindViewHolder(holder: CollectionsViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}