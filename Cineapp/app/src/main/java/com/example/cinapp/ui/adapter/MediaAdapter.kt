package com.example.cinapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinapp.R
import com.example.cinapp.model.Media

/*class MediaAdapter(private val viewModel: MainViewModel, private val lifecycleOwner: LifecycleOwner, private val nbLiveData: Int) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {*/
class MediaAdapter(private val mediaList: LiveData<List<Media>>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    //private var mediaList = emptyList<Media>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        Log.d("MediaAdapter", "onCreateViewHolder: $view")
        return ViewHolder(view)
    }

    /*fun subscribe(viewModel: MainViewModel, lifecycleOwner: LifecycleOwner, nbLiveData: Int) {
        viewModel.getMediaLiveData(nbLiveData).observe(lifecycleOwner, Observer {
            mediaList = it
            notifyDataSetChanged()
            Log.d("MediaAdapter", "subscribe: $it")
        })
    }*/

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
            }
        }
        /*Log.d("MediaAdapter", "onBindViewHolder: $media")*/
       /* subscribe(viewModel, lifecycleOwner, nbLiveData)*/
        /*val movie = mediaList[position]
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .override(400, 600)
            .into(holder.poster)*/

       /* holder.poster.setOnClickListener {
            Log.d("MediaAdapter", "onBindViewHolder: $media")
        }*/

    }
    override fun getItemCount(): Int {
        return mediaList.value?.size ?: 0
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.poster)
    }
}

