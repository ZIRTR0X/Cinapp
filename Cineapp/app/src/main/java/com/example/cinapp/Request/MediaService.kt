package com.example.cinapp.Request

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaService {
    @GET("search/movie?api_key=e53e59cf1e29b9afff93d9ca1208f0cf&query=Forrest%20Gump&language=fr")
    fun getForrestGump(): Call<Demmy>

    @GET("search/multi")
    fun searchMedia(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("include_adult") includeAdult: Boolean
    ): Call<Demmy>

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<Demmy>
}