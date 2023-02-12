package com.example.cinapp.ui.viewModel

import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.api.MediaRepository
import com.example.cinapp.model.Media
import com.example.cinapp.ui.adapter.MediaAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var medias = MutableLiveData<List<Media>>()
    lateinit var main: MainActivity;

    @JvmName("setSearchView1")
    fun setMediaList(rootView: View) {

        viewModelScope.launch(Dispatchers.IO) {
            MediaRepository().getTopRatedSerie { listMedia ->
                medias.postValue(listMedia)
                val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_view_movies)
                val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = MediaAdapter(medias, main)
            }
        }
    }
}
