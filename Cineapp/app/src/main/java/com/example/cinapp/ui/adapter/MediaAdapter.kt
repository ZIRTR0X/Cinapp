package com.example.cinapp.ui.adapter

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
import com.example.cinapp.ui.fragments.MovieInfo

class MediaAdapter(private val mediaList: LiveData<List<Media>>, private val main: MainActivity) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    init {
        mediaList.observe(main, Observer {
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mediaList.observeForever {
            val media = it[position]
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w500" + media.posterPath)
                .override(400, 600)
                .into(holder.poster)
            holder.poster.setOnClickListener {
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

