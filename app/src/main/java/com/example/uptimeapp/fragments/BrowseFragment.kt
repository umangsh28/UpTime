package com.example.uptimeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.uptimeapp.DeepDiveActivity
import com.example.uptimeapp.R
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