package com.example.cinapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cinapp.R
import com.example.cinapp.adapter.MediaAdapter
import com.example.cinapp.Request.MediaApi
import com.example.cinapp.model.Media

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        //getPopularMovies
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        MediaApi().getPopularMovies() { listMedia ->
            val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_popular_movies)
            addMediaToRecyclerView(listMedia, recyclerView)
        }

        MediaApi().getPopularSeries() { listMedia ->
            val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_popular_series)
            addMediaToRecyclerView(listMedia, recyclerView)
        }

        MediaApi().getTopRatedMovie() { listMedia ->
            val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_top_rated_movies)
            addMediaToRecyclerView(listMedia, recyclerView)
        }

        MediaApi().getTopRatedSerie() { listMedia ->
            val recyclerView = rootView.findViewById<RecyclerView>(R.id.rc_top_rated_series)
            addMediaToRecyclerView(listMedia, recyclerView)
        }

        return rootView
    }

    fun addMediaToRecyclerView(listMedia: List<Media>, recyclerView: RecyclerView) {
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = layoutManager
        val adapter = MediaAdapter(listMedia)
        recyclerView.adapter = adapter
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
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}