package com.example.cinapp.Request

import com.example.cinapp.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaService {
    @GET("search/multi")
    fun searchMedia(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "fr",
        @Query("include_adult") includeAdult: Boolean = true
    ): Call<Demmy>

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<Demmy>

    @GET("tv/popular")
    fun getPopularSeries(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<Demmy>

    @GET("movie/top_rated")
    fun getTopRatedMovie(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<Demmy>

    @GET("tv/top_rated")
    fun getTopRatedSerie(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<Demmy>
}