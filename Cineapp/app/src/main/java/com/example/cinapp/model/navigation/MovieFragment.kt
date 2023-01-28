package com.example.cinapp.model.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinapp.R
import com.example.cinapp.Request.Demmy
import com.example.cinapp.Request.MediaApi
import com.example.cinapp.Request.MediaService
import com.example.cinapp.Request.MoviesAdapter
import com.example.cinapp.model.Media
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {
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

        // Récupération de la vue racine
        val rootView = inflater.inflate(R.layout.fragment_movie, container, false)

        // Récupération de la vue souhaitée
        val myView = rootView.findViewById<TextView>(R.id.name)

        //var listMedias : Unit = MediaApi().search("e53e59cf1e29b9afff93d9ca1208f0cf", "en-US", "One Piece", 1, false) { listMedia -> listMedia }
        //var listMedia : List<Media> = MediaApi().getPopularMovies("e53e59cf1e29b9afff93d9ca1208f0cf")
        //var listMedia : List<Media> = MediaApi().getForrestGump()

        val apiKey = "e53e59cf1e29b9afff93d9ca1208f0cf"
        val language = "en-US"
        val query = "One Piece"
        val page = 1
        val includeAdult = false
        MediaApi().search(apiKey, language, query, page, includeAdult) { listMedia ->
            //Do something with listMedia
            Log.d("TAG", "onCreateView: " + listMedia)
            Log.d("Image", "onCreateView: " + listMedia[0].posterPath.toString())
            myView.text = listMedia[0].title.toString() + " " + listMedia[0].id.toString() + " " + listMedia[0].posterPath.toString()
        }

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MovieFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}