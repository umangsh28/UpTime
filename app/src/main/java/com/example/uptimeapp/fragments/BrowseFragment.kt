package com.example.uptimeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.uptimeapp.DeepDiveActivity
import com.example.uptimeapp.R
import com.example.uptimeapp.TopicActivity

class BrowseFragment : Fragment(R.layout.fragment_browse) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun openDeepDiveActivity(string : String){

        val intent = Intent(context, DeepDiveActivity::class.java)
        intent.putExtra("deepDiveKey", string)
        startActivity(intent)
    }

    private fun openTopicActivity(topic : String){

        val intent = Intent(context, TopicActivity::class.java)
        intent.putExtra("deepDiveKey", topic)
        startActivity(intent)
    }
}