package com.example.cinapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinapp.data.persistance.MediaDatabase
import com.example.cinapp.model.Media
import com.example.cinapp.model.Movie
import com.example.cinapp.model.Serie
import com.example.cinapp.ui.extensions.MovieExtensions
import com.example.cinapp.ui.extensions.SerieExtensions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MediaInfoViewModel: ViewModel() {
    fun addMovieToWatchList() {
        TODO("Not yet implemented")
    }

    fun addSerieToWatchList() {
        TODO("Not yet implemented")
    }

    fun addMediaToWatchList(db: MediaDatabase, media: Media) {
        viewModelScope.launch(Dispatchers.IO) {
            if (media is Movie) {
                val movieEntity = MovieExtensions.toMovieEntity(media)
                db?.movieDAO()?.insert(movieEntity)
            } else {
                val serieEntity = SerieExtensions.toSerieEntity(media as Serie)
                db?.serieDAO()?.insert(serieEntity)
            }
        }
    }

    fun removeMediaFromWatchList(db: MediaDatabase, media: Media) {
        viewModelScope.launch(Dispatchers.IO) {
            if (media is Movie) {
                val movieEntity = MovieExtensions.toMovieEntity(media)
                db?.movieDAO()?.delete(movieEntity)
            } else {
                val serieEntity = SerieExtensions.toSerieEntity(media as Serie)
                db?.serieDAO()?.delete(serieEntity)
            }
        }
    }

    fun isMediaInWatchList(db: MediaDatabase, media: Media): Boolean {
        var isInWatchList = false
        viewModelScope.launch(Dispatchers.IO) {
            if (media is Movie) {
                val movieEntity = MovieExtensions.toMovieEntity(media)
                isInWatchList = db?.movieDAO()?.getById(movieEntity.id) != null
            } else {
                val serieEntity = SerieExtensions.toSerieEntity(media as Serie)
                isInWatchList = db?.serieDAO()?.getById(serieEntity.id) != null
            }
        }
        Log.d("isInWatchList", isInWatchList.toString())
        return isInWatchList
    }

}
