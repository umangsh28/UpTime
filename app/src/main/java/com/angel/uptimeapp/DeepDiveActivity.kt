package com.angel.uptimeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.angel.uptimeapp.bookhack.interfaces.BookHacksDataLoadListener
import com.angel.uptimeapp.bookhack.ui.BookHackAdapter
import com.angel.uptimeapp.bookhack.viewmodel.BookViewModel
import com.angel.uptimeapp.collection.interfaces.CollectionDataLoadListener
import com.angel.uptimeapp.collection.ui.CollectionsAdapter
import com.angel.uptimeapp.collection.viewmodel.CollectionsViewModel
import com.angel.uptimeapp.coursehack.interfaces.CourseHacksDataLoadListener
import com.angel.uptimeapp.coursehack.ui.CourseHackAdapter
import com.angel.uptimeapp.coursehack.viewmodel.CourseViewModel
import com.angel.uptimeapp.documentaryhack.interfaces.DocumentaryHacksDataLoadListener
import com.angel.uptimeapp.documentaryhack.ui.DocumentaryHackAdapter
import com.angel.uptimeapp.documentaryhack.viewmodel.DocumentaryViewModel
import kotlinx.android.synthetic.main.activity_deep_dive.*

class DeepDiveActivity : AppCompatActivity(), BookHacksDataLoadListener,
    CourseHacksDataLoadListener, DocumentaryHacksDataLoadListener, CollectionDataLoadListener {

    lateinit var bookViewModel: BookViewModel
    lateinit var courseViewModel: CourseViewModel
    lateinit var documentaryViewModel: DocumentaryViewModel
    lateinit var collectionsViewModel: CollectionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_dive)

        back.setOnClickListener{finish()}

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
                    loadDocumentaryData("New Hacks")
                }
                else -> loadBooksData("Topics")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadCollectionsData(title: String) {

        toolbarText.text = title
        collectionsViewModel = ViewModelProviders.of(this).get(CollectionsViewModel::class.java)
        collectionsViewModel.init(this)
        onCollectionDataLoaded()
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    private fun loadBooksData(title: String) {

        toolbarText.text = title
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.init(this)
        onBookHacksDataLoaded()
    }

    @SuppressLint("SetTextI18n")
    private fun loadCourseHackData(title: String) {

        toolbarText.text = title
        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel::class.java)
        courseViewModel.init(this)
        onCourseHacksDataLoaded()
    }

    @SuppressLint("SetTextI18n")
    private fun loadDocumentaryData(title: String) {

        toolbarText.text = title
        documentaryViewModel = ViewModelProviders.of(this).get(DocumentaryViewModel::class.java)
        documentaryViewModel.init(this)
        onDocumentaryHacksDataLoaded()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBookHacksDataLoaded() {

        bookViewModel.geData().observe(this, {

            if (it.isNotEmpty()) progressBar.visibility = View.GONE

            recyclerView.layoutManager = GridLayoutManager(this, 2)
            val adapter = BookHackAdapter(it, "Book Hacks")
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCourseHacksDataLoaded() {

        courseViewModel.geData().observe(this, {

            if (it.isNotEmpty()) progressBar.visibility = View.GONE

            recyclerView.layoutManager = GridLayoutManager(this, 2)
            val adapter = CourseHackAdapter(it, "Course Hacks")
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onDocumentaryHacksDataLoaded() {

        documentaryViewModel.geData().observe(this, {

            if (it.isNotEmpty()) progressBar.visibility = View.GONE

            recyclerView.layoutManager = GridLayoutManager(this, 2)
            val adapter = DocumentaryHackAdapter(it, "Documentary Hacks")
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCollectionDataLoaded() {

        collectionsViewModel.geData().observe(this, {

            if (it.isNotEmpty()) progressBar.visibility = View.GONE

            recyclerView.layoutManager = LinearLayoutManager(this)
            val adapter = CollectionsAdapter(it)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }
}