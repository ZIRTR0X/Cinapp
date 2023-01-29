package com.example.cinapp.Request

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaService {
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

    @GET("tv/popular")
    fun getPopularSeries(@Query("api_key") apiKey: String): Call<Demmy>

    @GET("movie/top_rated")
    fun getTopRatedMovie(@Query("api_key") apiKey: String): Call<Demmy>

    @GET("tv/top_rated")
    fun getTopRatedSerie(@Query("api_key") apiKey: String): Call<Demmy>
}