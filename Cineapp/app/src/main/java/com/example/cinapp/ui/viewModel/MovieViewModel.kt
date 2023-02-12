package com.example.cinapp.ui.viewModel

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.data.persistance.Entity.AppDatabase
import com.example.cinapp.data.persistance.Entity.MovieEntity
import com.example.cinapp.model.Media
import com.example.cinapp.ui.adapter.MediaAdapter
import com.example.cinapp.ui.extensions.MovieExtensions
import kotlinx.coroutines.*

class MovieViewModel: ViewModel() {
    var medias = MutableLiveData<List<Media>>()
    @SuppressLint("StaticFieldLeak")
    lateinit var main: MainActivity;

    @JvmName("setSearchView1")
    fun setMediaList(rootView: View) {
        viewModelScope.launch(Dispatchers.IO) {
            var listMediaEntity = downloadMedia()
            var listeMedia : MutableList<Media> = mutableListOf()
            listMediaEntity.forEach() {
                listeMedia.add(MovieExtensions.toMovie(it))
            }
            medias.postValue(listeMedia)
        }
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_view_movies)
        val context = rootView.context
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = MediaAdapter(medias, main)
    }


    suspend fun downloadMedia(): List<MovieEntity> {
        return withContext(Dispatchers.IO) {
            val db = AppDatabase.getInstance()
            db.movieDAO().getAll()
        }
    }
}
