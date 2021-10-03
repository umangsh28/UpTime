package com.example.uptimeapp.bookhack.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uptimeapp.R
import com.example.uptimeapp.bookhack.model.BookHackModel
import kotlinx.android.synthetic.main.book_hack_row_item.view.*

class BookHackAdapter(private val list: ArrayList<BookHackModel>, private val key : String) :
    RecyclerView.Adapter<BookHackAdapter.BookHackViewHolder>() {

    class BookHackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val type: TextView = itemView.findViewById(R.id.type)

        fun setData(model: BookHackModel) {

            itemView.apply {

                Glide.with(img)
                    .load(model.imgUrl)
                    .into(img)
                name.text = model.name
                writer.text = model.writer
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHackViewHolder {
        return BookHackViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.book_hack_row_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookHackViewHolder, position: Int) {
        holder.type.text = key
        holder.setData(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}