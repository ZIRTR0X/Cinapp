package com.example.cinapp.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.model.Media
import com.example.cinapp.ui.viewModel.HomeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment(private var main: MainActivity?) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var viewModel = HomeViewModel(main!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val popularMoviesList = viewModel.popularMovies.value
        val popularMoviesArrayList = popularMoviesList?.toCollection(ArrayList())

        val popularSeriesList = viewModel.popularTvShows.value
        val popularSeriesArrayList = popularSeriesList?.toCollection(ArrayList())

        val topRatedMoviesList = viewModel.topRatedMovies.value
        val topRatedMoviesArrayList = topRatedMoviesList?.toCollection(ArrayList())

        val topRatedSeriesList = viewModel.topRatedTvShows.value
        val topRatedSeriesArrayList = topRatedSeriesList?.toCollection(ArrayList())

        outState.putParcelableArrayList("popularMovies", popularMoviesArrayList)
        outState.putParcelableArrayList("popularSeries", popularSeriesArrayList)
        outState.putParcelableArrayList("topRatedMovies", topRatedMoviesArrayList)
        outState.putParcelableArrayList("topRatedSeries", topRatedSeriesArrayList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        if (savedInstanceState != null) {
            val list = savedInstanceState.getParcelableArrayList<Media>("popularMovies")
            viewModel.popularMovies.postValue(list)
            val list2 = savedInstanceState.getParcelableArrayList<Media>("popularSeries")
            viewModel.popularTvShows.postValue(list2)
            val list3 = savedInstanceState.getParcelableArrayList<Media>("topRatedMovies")
            viewModel.topRatedMovies.postValue(list3)
            val list4 = savedInstanceState.getParcelableArrayList<Media>("topRatedSeries")
            viewModel.topRatedTvShows.postValue(list4)
        }
        viewModel = HomeViewModel(main!!)
        viewModel.addMedia(rootView)
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment(null).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}