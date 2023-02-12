package com.example.cinapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.ui.viewModel.HomeViewModel

class HomeFragment(private var main: MainActivity?) : Fragment() {

    private var viewModel = HomeViewModel(main!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = HomeViewModel(main!!)
        viewModel.addMedia(rootView)
        return rootView
    }
}