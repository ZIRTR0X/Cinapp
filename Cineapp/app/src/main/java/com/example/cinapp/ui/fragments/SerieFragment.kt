package com.example.cinapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.ui.viewModel.MovieViewModel
import com.example.cinapp.ui.viewModel.SerieViewModel

class SerieFragment : Fragment() {
    lateinit var main: MainActivity
    private lateinit var vm: SerieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_serie, container, false)
        vm = SerieViewModel()
        vm.main = main
        vm.setMediaList(rootView)
        return rootView
    }
}