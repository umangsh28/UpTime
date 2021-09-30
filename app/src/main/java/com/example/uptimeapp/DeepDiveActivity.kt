package com.example.uptimeapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_deep_dive.*

class DeepDiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_dive)

        val value = intent.getStringExtra("key")

        if (value != null) {
            if (value.lowercase().contains("collections")){
                loadCollectionsData()
            }
        }
    }

    private fun loadCollectionsData() {

        val list : MutableList<CollectionsModel>? = null
        val database = FirebaseDatabase.getInstance().reference

        database.child("DeepDive").child("Collections")
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()){

                        for (data in snapshot.children) {

                            val model = data.getValue(CollectionsModel::class.java)

                            if (model != null) {

                                list?.add(model)
                            }
                        }

                        if (list != null) {
                            if (list.size == 0){
                                Toast.makeText(this@DeepDiveActivity, "Data", Toast.LENGTH_LONG).show()
                            }else{

                                Toast.makeText(this@DeepDiveActivity, "Data not f", Toast.LENGTH_LONG).show()
                            }
                        }

                        list?.shuffle()

                        val adapter = list?.let { CollectionsAdapter(it) }
                        recyclerView.adapter = adapter
                        adapter?.notifyDataSetChanged()

                    } else{

                        Toast.makeText(this@DeepDiveActivity, "Data not found", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@DeepDiveActivity, error.message, Toast.LENGTH_LONG).show()
                }
            })
    }
}