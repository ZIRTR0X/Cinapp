package com.example.cinapp.Request

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.cinapp.R
import com.example.cinapp.model.Media

class MediaAdapter(private val medias: List<Media>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = medias[position]
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .override(400, 600) // dimensions cibles en pixels
            //.transform(RoundedCorners(20)) // 20 pixels de rayon pour les angles
            .into(holder.poster)

    }
    override fun getItemCount(): Int {
        return medias.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.poster)
    }
}

