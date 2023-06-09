package com.example.cinapp.api.dto

class MediaResponse(
    val adult: Boolean,
    val id: Int,
    val name: String,
    val media_type: String,
    val backdrop_path: String,
    val first_air_date: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview : String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int,
    val genre_ids: List<Int>,
    val original_title: String,
    val title: String,
    val release_date: String
) {

}