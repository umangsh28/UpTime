package com.example.uptimeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.uptimeapp.DeepDiveActivity
import com.example.uptimeapp.R
import com.example.uptimeapp.TopicActivity
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_browse.*

class BrowseFragment : Fragment(R.layout.fragment_browse), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collections.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        var key : String? = null
        var intent : Intent ? = null

        if (v is MaterialButton){

            key = v.text.toString()
            intent = Intent(context, TopicActivity::class.java)

        } else if (v is TextView){
            key = v.text.toString()
            intent = Intent(context, DeepDiveActivity::class.java)

        }

        intent?.putExtra("key", key)
        startActivity(intent)
    }
}