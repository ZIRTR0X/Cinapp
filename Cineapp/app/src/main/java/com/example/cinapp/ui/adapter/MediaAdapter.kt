package com.example.cinapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinapp.MainActivity
import com.example.cinapp.R
import com.example.cinapp.model.Media
import com.example.cinapp.ui.fragments.MovieFragment
import com.example.cinapp.ui.fragments.MovieInfo

class MediaAdapter(private val mediaList: LiveData<List<Media>>, private val main: MainActivity) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    init {
        mediaList.observe(main, Observer {
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        Log.d("MediaAdapter", "onCreateViewHolder: $view")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mediaList.observeForever {
            var media = it[position]
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w500" + media.posterPath)
                .override(400, 600)
                .into(holder.poster)
            Log.d("MediaAdapter", "onBindViewHolder: $media")
            holder.poster.setOnClickListener {
                Log.d("MediaAdapter", "onBindViewHolder: $media")
                //changer de fragment
                val fragment = MovieInfo()
                fragment.media = media
                main.replaceFragment(fragment)
            }
        }
    }
    override fun getItemCount(): Int {
        return mediaList.value?.size ?: 0
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.poster)
    }
}

