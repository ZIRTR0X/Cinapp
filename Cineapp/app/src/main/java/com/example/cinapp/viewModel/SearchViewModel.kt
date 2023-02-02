package com.example.cinapp.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel

@SuppressLint("StaticFieldLeak")
class SearchViewModel : ViewModel() {

    var searchView: SearchView? = null

    @JvmName("setSearchView1")
    fun setSearchView(searchView: SearchView) {
        this.searchView = searchView
        Log.d("SearchViewModel", "setSearchView: $searchView")
    }


    var sv = searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            // Traitement lors de la soumission de la requête
            Log.d("SearchViewModel", "onQueryTextSubmit: $query")
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            // Traitement lorsque le texte de la requête change
            Log.d("SearchViewModel", "onQueryTextSubmit: $newText")
            return false
        }
    })
}