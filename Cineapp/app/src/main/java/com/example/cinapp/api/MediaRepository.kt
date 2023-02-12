package com.example.cinapp.api

import android.util.Log
import com.example.cinapp.api.dto.Demmy
import com.example.cinapp.model.Media
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MediaRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service = retrofit.create(MediaService::class.java)
    val mediaMapper = MediaMapper()

    fun search(query: String, page: Int, callback: (List<Media>) -> Unit) {
        val response: Call<Demmy> = service.searchMedia(query, page)
        val listMedia: MutableList<Media> = mutableListOf()

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                val allMedia = response.body()
                val listMediaResponse = allMedia?.results
                listMediaResponse?.forEach { mediaResponse ->
                    val media = mediaMapper.searchMapToMedia(mediaResponse)
                    if (media != null) listMedia.add(media)
                }
                callback(listMedia)
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })
    }

    fun getPopularMovies(callback: (List<Media>) -> Unit ) {
        val response: Call<Demmy> = service.getPopularMovies()
        val listMedia: MutableList<Media> = mutableListOf()

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                val allMedia = response.body()!!
                val listMediaResponse = allMedia.results
                listMediaResponse.forEach { mediaResponse ->
                    listMedia.add(mediaMapper.mapToMovie(mediaResponse))
                }
                callback(listMedia)
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })
    }

    fun getPopularSeries(callback: (List<Media>) -> Unit ) {
        val response: Call<Demmy> = service.getPopularSeries()
        val listMedia: MutableList<Media> = mutableListOf()

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                val allMedia = response.body()!!
                val listMediaResponse = allMedia.results
                listMediaResponse.forEach { mediaResponse ->
                    listMedia.add(mediaMapper.mapToSerie(mediaResponse))
                }
                callback(listMedia)
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })
    }

    fun getTopRatedMovie(callback: (List<Media>) -> Unit ) {
        val response: Call<Demmy> = service.getTopRatedMovie()
        val listMedia: MutableList<Media> = mutableListOf()

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                val allMedia = response.body()!!
                val listMediaResponse = allMedia.results
                listMediaResponse.forEach { mediaResponse ->
                    listMedia.add(mediaMapper.mapToMovie(mediaResponse))
                }
                callback(listMedia)
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })
    }

    fun getTopRatedSerie(callback: (List<Media>) -> Unit ) {
        val response: Call<Demmy> = service.getTopRatedSerie()
        val listMedia: MutableList<Media> = mutableListOf()

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                val allMedia = response.body()!!
                val listMediaResponse = allMedia.results
                listMediaResponse.forEach { mediaResponse ->
                    listMedia.add(mediaMapper.mapToSerie(mediaResponse))
                }
                callback(listMedia)
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })
    }
}