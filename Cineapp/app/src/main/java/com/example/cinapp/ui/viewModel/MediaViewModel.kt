package com.example.cinapp.ui.viewModel

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.cinapp.model.Media

class MediaViewModel: ViewModel() {

    fun onMediaClicked(media: Media) {

    }

    fun getMediaLiveData(mediaId: Int): Any {
        return Intent()
    }
}