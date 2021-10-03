package com.example.uptimeapp

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var mTTs: TextToSpeech
    private lateinit var thread: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        name.text = intent.getStringExtra("name")
        writer.text = intent.getStringExtra("writer")
        val s = intent.getStringExtra("desc")

        content.text = s
        finish.setOnClickListener { finish() }
        switchToAudio.setOnClickListener { startAudio(s!!) }

        mTTs = TextToSpeech(applicationContext) { status ->

            if (status != TextToSpeech.ERROR) {

                mTTs.language = Locale.UK
            }
        }

        thread = object : Thread() {
            override fun run() {
                while (true) {

                    if (mTTs.isSpeaking) {
                        CoroutineScope(Dispatchers.Main).launch {
                            progressBar.visibility = View.VISIBLE
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            progressBar.visibility = View.GONE
                        }
                    }
                }
            }
        }
        thread.start()
        findViewById<TextView>(R.id.rl3)
        val animation=AnimationUtils.loadAnimation(this,R.anim.nav_default_pop_enter_anim)
        animation.duration=5000
        rl3.startAnimation(animation)
    }



    private fun startAudio(s: String) {

        if(mTTs.isSpeaking) {
            mTTs.stop()
        }else{
            mTTs.speak(s, TextToSpeech.QUEUE_FLUSH, null, "")
        }
    }
}