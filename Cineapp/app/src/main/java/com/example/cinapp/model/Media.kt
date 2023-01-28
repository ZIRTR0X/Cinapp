package com.example.cinapp.model

open class Media (
    val adult: Boolean? = null,
    val id: Int,
    val title: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val originCountry: List<String>? = null,
    val originalLanguage: String? = null,
    val originalName: String? = null,
    val overview : String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null,
    val genreIds: List<Int>? = null
        ){
}