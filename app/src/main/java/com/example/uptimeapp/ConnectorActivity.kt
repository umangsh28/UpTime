package com.example.uptimeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_connector.*
import kotlinx.android.synthetic.main.activity_main.*

class ConnectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connector)
        val navController = findNavController(R.id.nav_host_fragment_container)
        bottomNavigationView.setupWithNavController(navController)
    }
}