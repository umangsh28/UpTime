package com.example.uptimeapp.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.uptimeapp.DeepDiveActivity
import com.example.uptimeapp.R
import com.example.uptimeapp.SearchResultAdapter
import com.example.uptimeapp.bookhack.model.BookHackModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import kotlinx.android.synthetic.main.fragment_browse.*

class BrowseFragment : Fragment(R.layout.fragment_browse), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collections.setOnClickListener(this)
        booksHacks.setOnClickListener(this)
        courseHacks.setOnClickListener(this)
        documentaryHacks.setOnClickListener(this)
        uptimeRecommends.setOnClickListener(this)
        trendingHacks.setOnClickListener(this)
        newHacks.setOnClickListener(this)

        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val input = s.toString()

                if (input.isEmpty()) {
                    recyclerView.visibility = View.GONE
                    nestedScrollView.visibility = View.VISIBLE
                } else {
                    nestedScrollView.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }

                showResult(input)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun showResult(s: String) {

        val list: ArrayList<BookHackModel> = ArrayList()

        val reference =
            FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("Books")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snapshot1 in snapshot.children) {
                        val model = snapshot1.getValue(BookHackModel::class.java)

                        if (model != null) {
                            if (model.name.contains(s) || model.writer.contains(s)) {
                                list.add(model)
                            }
                        }
                    }

                    val adapter = context?.let { SearchResultAdapter(list, it) }
                    recyclerView.adapter = adapter
                    adapter?.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("key", error.message)
            }
        })
    }

    override fun onClick(v: View?) {

        val intent: Intent?

        val key: String = if (v is TextView) {

            v.text.toString()
        } else {
            "Topics"
        }

        intent = Intent(context, DeepDiveActivity::class.java)
        intent.putExtra("key", key.filter { !it.isWhitespace() })
        startActivity(intent)
    }
}