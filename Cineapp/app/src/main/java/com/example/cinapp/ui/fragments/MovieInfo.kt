package com.example.cinapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.cinapp.data.persistance.Entity.AppDatabase
import com.example.cinapp.data.persistance.MediaDatabase
import com.example.cinapp.databinding.FragmentMovieInfoBinding
import com.example.cinapp.model.Media
import com.example.cinapp.model.Movie
import com.example.cinapp.model.Serie
import com.example.cinapp.ui.extensions.MovieExtensions
import com.example.cinapp.ui.extensions.SerieExtensions
import com.example.cinapp.ui.viewModel.MediaInfoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var binding: FragmentMovieInfoBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MovieInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieInfo() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var media: Media? = null
    private var vm = MediaInfoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MovieInfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}