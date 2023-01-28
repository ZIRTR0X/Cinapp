package com.example.cinapp.Request

import android.util.Log
import com.example.cinapp.model.Media
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MediaApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service = retrofit.create(MediaService::class.java)
    val mediaMapper = MediaMapper()

    fun search(apiKey: String, language: String, query: String, page: Int, includeAdult: Boolean, callback: (List<Media>) -> Unit) {
        val response: Call<Demmy> = service.searchMedia(apiKey, language, query, page, includeAdult)
        val listMedia: MutableList<Media> = mutableListOf()
        Log.d("TAG", "search: " + response.request().url())

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                Log.d("Liste1", response.body().toString())
                val allMedia = response.body()
                val listMediaResponse = allMedia?.results
                listMediaResponse?.forEach { mediaResponse ->
                    val media = mediaMapper.searchMapToMedia(mediaResponse)
                    Log.d("Media", media.toString())
                    listMedia.add(media)
                }
                callback(listMedia)
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })
        Log.d("Liste2", listMedia.size.toString())
    }

    fun getPopularMovies(apiKey: String): List<Media> {
        val response: Call<Demmy> = service.getPopularMovies(apiKey)
        val listMedia: MutableList<Media> = mutableListOf()

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                Log.d("Liste1", response.body().toString())
                val allMedia = response.body()!!
                val listMediaResponse = allMedia.results
                listMediaResponse.forEach { mediaResponse ->
                    listMedia.add(mediaMapper.searchMapToMedia(mediaResponse))
                }
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })

        return listMedia
    }

    fun getForrestGump(): List<Media> {
        val response: Call<Demmy> = service.getForrestGump()
        val listMedia: MutableList<Media> = mutableListOf()

        response.enqueue(object : Callback<Demmy> {
            override fun onResponse(call: Call<Demmy>, response: Response<Demmy>) {
                Log.d("Liste1", response.body().toString())
                val allMedia = response.body()!!
                val listMediaResponse = allMedia.results
                listMediaResponse.forEach { mediaResponse ->
                    listMedia.add(mediaMapper.searchMapToMedia(mediaResponse))
                }
            }

            override fun onFailure(call: Call<Demmy>, t: Throwable) {
                Log.d("ErrorRetrofit", t.message.toString())
            }
        })

        return listMedia
    }
}