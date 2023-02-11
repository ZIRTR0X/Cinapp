package com.example.cinapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinapp.R
import com.example.cinapp.model.Media
import com.example.cinapp.ui.viewModel.MediaViewModel

class InfosMediaAdapter(private val viewModel: MediaViewModel) : RecyclerView.Adapter<InfosMediaAdapter.MediaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_view, parent, false)
        return MediaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        /*val media = mediaList[position]
        holder.bind(media)*/
    }

    override fun getItemCount(): Int {
        /*return mediaList.size*/
        return 0
    }

    inner class MediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*private val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        private val mediaImageView: ImageView = itemView.findViewById(R.id.media_image_view)

        fun bind(media: Media) {
            titleTextView.text = media.title
            descriptionTextView.text = media.description
            // Ajoutez une logique pour charger l'image à partir de l'URL pour le média
        }*/
    }
}

