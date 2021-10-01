package com.example.uptimeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uptimeapp.bookhack.DataLoadListener
import com.example.uptimeapp.bookhack.ui.BookHackAdapter
import com.example.uptimeapp.bookhack.model.BookHackModel
import com.example.uptimeapp.bookhack.viewmodel.BookViewModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_deep_dive.*

class DeepDiveActivity : AppCompatActivity() , DataLoadListener{

    lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_dive)

        val value = intent.getStringExtra("key")

        if (value != null) {

            when {
                value.lowercase().contains("collections") -> {
                    loadCollectionsData("Collections")
                }
                value.lowercase().contains("bookhacks") -> {
                    loadBooksData("Book Hacks")
                }
                value.lowercase().contains("trendinghacks") -> {
                    loadBooksData("Trending Hacks")
                }
                value.lowercase().contains("coursehacks") -> {
                    loadCourseHackData("Course Hacks")
                }
                value.lowercase().contains("documentaryhacks") -> {
                    loadDocumentaryData("Documentary Hacks")
                }
                value.lowercase().contains("uptimerecommends") -> {
                    loadDocumentaryData("Uptime Recommends")
                }
                value.lowercase().contains("newhacks") -> {
                    loadUptimeData("New Hacks")
                }
                else -> loadBooksData("Topics")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadCollectionsData(title: String) {

        toolbarText.text = title
        val list = ArrayList<CollectionsModel>()

        val reference =
            FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("Collections")

        reference.addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (data in snapshot.children) {

                        val model = data.getValue(CollectionsModel::class.java)

                        if (model != null) {

                            list.add(model)
                        }
                    }

                    list.shuffle()

                    val adapter = CollectionsAdapter(list)
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                } else {

                    Toast.makeText(this@DeepDiveActivity, "Data not found", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DeepDiveActivity, error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    private fun loadBooksData(title: String) {

        toolbarText.text = title

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.init(this)

        val adapter = BookHackAdapter(bookViewModel.geData().value!!, "Book Hacks")
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()





//        val list = ArrayList<BookHackModel>()
//
//        val reference =
//            FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
//                .getReference("Books")
//
//        reference.addValueEventListener(object : ValueEventListener {
//
//            @SuppressLint("NotifyDataSetChanged")
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                if (snapshot.exists()) {
//
//                    for (data in snapshot.children) {
//
//                        val model = data.getValue(BookHackModel::class.java)
//
//                        if (model != null) {
//
//                            list.add(model)
//                        }
//                    }
//
//                    list.shuffle()
//
//                    val adapter = BookHackAdapter(list, title)
//                    recyclerView.adapter = adapter
//                    adapter.notifyDataSetChanged()
//
//                } else {
//
//                    Toast.makeText(this@DeepDiveActivity, "Data not found", Toast.LENGTH_LONG)
//                        .show()
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(this@DeepDiveActivity, error.message, Toast.LENGTH_LONG).show()
//            }
//        })
    }

    @SuppressLint("SetTextI18n")
    private fun loadCourseHackData(title: String) {

        toolbarText.text = title
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val list = ArrayList<CourseHackModel>()

        val reference =
            FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("CourseHacks")

        reference.addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (data in snapshot.children) {

                        val model = data.getValue(CourseHackModel::class.java)

                        if (model != null) {

                            list.add(model)
                        }
                    }

                    list.shuffle()

                    val adapter = CourseHackAdapter(list, title)
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                } else {

                    Toast.makeText(this@DeepDiveActivity, "Data not found", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DeepDiveActivity, error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun loadDocumentaryData(title: String) {

        toolbarText.text = title
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val list = ArrayList<CourseHackModel>()

        val reference =
            FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("DocumentaryHacks")

        reference.addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (data in snapshot.children) {

                        val model = data.getValue(CourseHackModel::class.java)

                        if (model != null) {

                            list.add(model)
                        }
                    }

                    list.shuffle()

                    val adapter = CourseHackAdapter(list, title)
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                } else {

                    Toast.makeText(this@DeepDiveActivity, "Data not found", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DeepDiveActivity, error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun loadUptimeData(title: String) {

        toolbarText.text = title
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val list = ArrayList<CourseHackModel>()

        val reference =
            FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("DocumentaryHacks")

        reference.addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (data in snapshot.children) {

                        val model = data.getValue(CourseHackModel::class.java)

                        if (model != null) {

                            list.add(model)
                        }
                    }

                } else {

                    Toast.makeText(this@DeepDiveActivity, "Data not found", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DeepDiveActivity, error.message, Toast.LENGTH_LONG).show()
            }
        })

        val reference2 =
            FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("CourseHacks")

        reference2.addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (data in snapshot.children) {

                        val model = data.getValue(CourseHackModel::class.java)

                        if (model != null) {

                            list.add(model)
                        }
                    }
                } else {

                    Toast.makeText(this@DeepDiveActivity, "Data not found", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DeepDiveActivity, error.message, Toast.LENGTH_LONG).show()
            }
        })

        list.shuffle()

        val adapter = CourseHackAdapter(list, "")
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onDataLoaded() {

        bookViewModel.geData().observe(this, Observer {
            // adapter.notifyDataSetChanged()
        })
    }
}