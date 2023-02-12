package com.example.cinapp.ui.viewModel

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.ui.adapter.MediaAdapter
import com.example.cinapp.api.MediaRepository
import com.example.cinapp.model.Media

@SuppressLint("StaticFieldLeak")
class SearchViewModel : ViewModel() {
    var main: MainActivity? = null
    var medias = MutableLiveData<List<Media>>()

    var searchView: SearchView? = null

    @JvmName("setSearchView1")
    fun setSearchView(rootView: View) {
        searchView = rootView.findViewById(R.id.searchView)
        Log.d("SearchViewModel", "setSearchView: $searchView")

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                MediaRepository().search(query.toString(), 1)
                { listMedia ->
                    val textView = rootView.findViewById<View>(R.id.noResult)
                    val recyclerView = rootView.findViewById<RecyclerView>(R.id.searchRecyclerView)
                    if(listMedia.isEmpty()){
                        textView.visibility = View.VISIBLE
                    }else{
                        medias.postValue(listMedia)
                        textView.visibility = View.GONE
                        val context = rootView.context
                        recyclerView.layoutManager = GridLayoutManager(context, 2)
                        recyclerView.adapter = main?.let { MediaAdapter(medias, it) }
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }
}
