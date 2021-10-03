package com.example.uptimeapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.uptimeapp.R

class SparksFragment : Fragment(R.layout.fragment_sparks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TrendingcallApi()
    }

    private fun TrendingcallApi() {

    }

}