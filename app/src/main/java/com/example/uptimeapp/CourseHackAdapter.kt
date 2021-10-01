package com.example.uptimeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.course_hack_row_item.view.*

class CourseHackAdapter(private val list: MutableList<CourseHackModel>, private val type : String) :
    RecyclerView.Adapter<CourseHackAdapter.CourseHackViewHolder>() {

    class CourseHackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val type : TextView = itemView.findViewById(R.id.type)

        fun setData(model: CourseHackModel) {

            itemView.apply {

                Glide.with(img)
                    .load(model.imgUrl)
                    .into(img)
                name.text = model.title
                resource.text = model.subTitle
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHackViewHolder {
        return CourseHackViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.course_hack_row_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseHackViewHolder, position: Int) {
        if (type.isNotEmpty()){
            holder.type.text = type
        } else{
            holder.type.visibility = View.GONE
        }
        holder.setData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}