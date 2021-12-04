package com.angel.uptimeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.angel.uptimeapp.bookhack.model.BookHackModel
import kotlinx.android.synthetic.main.book_hack_row_item2.view.*

class SearchResultAdapter(private val list: ArrayList<BookHackModel>, private val context: Context) :
    RecyclerView.Adapter<SearchResultAdapter.BookHackViewHolder>() {

    class BookHackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
            LayoutInflater.from(parent.context).inflate(R.layout.book_hack_row_item2, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookHackViewHolder, position: Int) {
        holder.setData(list[position])
        holder.itemView.tag = list[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(context, BookDetailsActivity::class.java)
            intent.putExtra("name", list[position].name)
            intent.putExtra("writer", list[position].writer)
            intent.putExtra("desc", list[position].desc)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}