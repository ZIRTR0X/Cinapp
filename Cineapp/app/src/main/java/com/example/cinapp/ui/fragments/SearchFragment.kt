package com.example.cinapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.ui.viewModel.MediaViewModel
import com.example.cinapp.ui.viewModel.SearchViewModel

class SearchFragment(private var main: MainActivity?) : Fragment() {
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var mediaViewModel: MediaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelProvider = ViewModelProvider(this)
        mediaViewModel = viewModelProvider.get(MediaViewModel::class.java)
        Log.d("InfoSearch", "onCreateView: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("InfoSearch", "onCreateView: ")
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)
        val viewModelProvider = ViewModelProvider(this)

        searchViewModel = viewModelProvider.get(SearchViewModel::class.java)
        searchViewModel.setSearchView(rootView)
        searchViewModel.main = main

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}