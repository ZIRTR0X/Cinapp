package com.example.cinapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.ui.viewModel.MovieViewModel

class MovieFragment : Fragment() {
    lateinit var main: MainActivity
    private lateinit var vm: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_movie, container, false)
        vm = MovieViewModel()
        vm.main = main
        vm.setMediaList(rootView)
        return rootView
    }
}