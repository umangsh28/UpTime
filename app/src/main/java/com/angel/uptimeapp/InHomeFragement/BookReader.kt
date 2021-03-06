package com.angel.uptimeapp.InHomeFragement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_book_reader.*
import android.R
import android.os.Handler


class BookReader : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(com.angel.uptimeapp.R.layout.activity_book_reader)


        BookTrend()
        Business()
        Thriller()
        Fiction()


        animation()



    }


    private fun animation() {


        val animation=AnimationUtils.loadAnimation(this,R.anim.slide_out_right)
        animation.duration=10000

        text1.startAnimation(animation)



        val animation1=AnimationUtils.loadAnimation(this,R.anim.fade_in)
        animation1.duration=10000

        text2.startAnimation(animation1)



        val animation2=AnimationUtils.loadAnimation(this,R.anim.slide_in_left)
        animation2.duration=10000

        text33.startAnimation(animation2)

        val animation3=AnimationUtils.loadAnimation(this,R.anim.fade_out)
        animation3.duration=10000
        text44.startAnimation(animation3)



    }

    private fun Business() {
      var Business =intent.getStringExtra("business")
        text2.text=Business

    }

    private fun BookTrend() {
        var trend =intent.getStringExtra("dataa")
        text1.text=trend

    }

    private fun Thriller() {
        var thriller =intent.getStringExtra("thriller")
        text33.text=thriller

    }

    private fun Fiction() {
        var fiction =intent.getStringExtra("fiction")
        text44.text=fiction

    }


    private fun characterloop(){


        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {



                handler.postDelayed(this, 500) // set time here to refresh textView
            }
        })
    }



}

