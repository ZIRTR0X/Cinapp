package com.example.cinapp.ui.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.api.MediaRepository
import com.example.cinapp.model.Media
import com.example.cinapp.ui.adapter.MediaAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val main: MainActivity): ViewModel() {

    var popularMovies = MutableLiveData<List<Media>>()
    var popularTvShows = MutableLiveData<List<Media>>()
    var topRatedMovies = MutableLiveData<List<Media>>()
    var topRatedTvShows = MutableLiveData<List<Media>>()

    @SuppressLint("StaticFieldLeak")

    fun addMedia(rootView: View) {
        viewModelScope.launch(Dispatchers.IO){
            MediaRepository().getPopularMovies { listMedia ->
                popularMovies.postValue(listMedia)
                val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_popular_movies)
                addMediaToRecyclerView(recyclerView, popularMovies)
            }
        }

        viewModelScope.launch(Dispatchers.IO){
            MediaRepository().getPopularSeries { listMedia ->
                popularTvShows.postValue(listMedia)
                val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_popular_series)
                addMediaToRecyclerView(recyclerView, popularTvShows)
            }
        }

        viewModelScope.launch(Dispatchers.IO){
            MediaRepository().getTopRatedMovie { listMedia ->
                topRatedMovies.postValue(listMedia)
                val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_top_rated_movies)
                addMediaToRecyclerView(recyclerView, topRatedMovies)
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            MediaRepository().getTopRatedSerie { listMedia ->
                topRatedTvShows.postValue(listMedia)
                val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_top_rated_series)
                addMediaToRecyclerView(recyclerView, topRatedTvShows)
            }
        }
    }

    fun addMediaToRecyclerView(recyclerView: RecyclerView, mediaList: MutableLiveData<List<Media>>) {
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MediaAdapter(mediaList, main)
    }


}