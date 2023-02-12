package com.example.cinapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cinapp.data.persistance.Entity.AppDatabase
import com.example.cinapp.databinding.FragmentMovieInfoBinding
import com.example.cinapp.model.Media
import com.example.cinapp.ui.viewModel.MediaInfoViewModel

class MovieInfo() : Fragment() {
    var media: Media? = null
    private var vm = MediaInfoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMovieInfoBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.media = media
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + media?.backdropPath)
            .override(400, 600)
            .into(binding.infoImage)

        val db = AppDatabase.getInstance()

        if (vm.isMediaInWatchList(db, media!!)) {
            binding.infoRemoveView.visibility = View.VISIBLE
        } else {
            binding.infoAddView.visibility = View.VISIBLE
        }

        binding.infoAddView.setOnClickListener {
            binding.media?.isView = true
            binding.infoAddView.visibility = View.GONE
            binding.infoRemoveView.visibility = View.VISIBLE
            vm.addMediaToWatchList(db, media!!)
        }

        binding.infoRemoveView.setOnClickListener {
            binding.media?.isView = false
            binding.infoAddView.visibility = View.VISIBLE
            binding.infoRemoveView.visibility = View.GONE
            vm.removeMediaFromWatchList(db, media!!)
        }

        return binding.root
    }
}