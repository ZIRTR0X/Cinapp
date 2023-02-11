package com.example.cinapp.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cinapp.R
import com.example.cinapp.model.Media
import com.example.cinapp.ui.viewModel.MediaViewModel

class MediaDetailActivity : AppCompatActivity() {
    /*private lateinit var viewModel: MediaViewModel

    public lateinit var media: Media

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_view)

        val media = intent.getIntExtra("MEDIA", 0)
        viewModel = ViewModelProvider(this).get(MediaViewModel::class.java)

        var textView = findViewById<TextView>(R.id.info_name)

        viewModel.getMediaLiveData(mediaId).observe(this, Observer { media ->
            textView.text = media.title
        })
    }*/
}