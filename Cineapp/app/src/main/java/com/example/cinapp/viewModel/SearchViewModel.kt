package com.example.cinapp.viewModel

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cinapp.BuildConfig
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.Request.MediaAdapter
import com.example.cinapp.Request.MediaApi

@SuppressLint("StaticFieldLeak")
class SearchViewModel : ViewModel() {

    var searchView: SearchView? = null
    val context : MainActivity = MainActivity()

    @JvmName("setSearchView1")
    fun setSearchView(rootView: View) {
        searchView = rootView.findViewById(R.id.searchView)
        Log.d("SearchViewModel", "setSearchView: $searchView")

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Traitement lors de la soumission de la requête

                MediaApi().search(query.toString(), 1)
                { listMedia ->
                    val recyclerView = rootView.findViewById<RecyclerView>(R.id.searchRecyclerView)
                    recyclerView.layoutManager = GridLayoutManager(context, 2)
                    recyclerView.adapter = MediaAdapter(listMedia)

                }


                Log.d("SearchViewModel -----", "onQueryTextSubmit: $query")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Traitement lorsque le texte de la requête change
                Log.d("SearchViewModel *******", "onQueryTextChange: $newText")
                return false
            }
        })
    }
}
