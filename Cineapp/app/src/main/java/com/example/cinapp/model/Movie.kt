package com.example.cinapp.model

class Movie(
    override val id: Int,
    override val name: String,
    override val backdropPath: String,
    override val releaseDate: String,
    override val originCountry: List<String>,
    override val originalLanguage: String,
    override val originalName: String,
    override val overview: String,
    override val popularity: Double,
    override val posterPath: String,
    override val voteAverage: Double,
    override val voteCount: Int,
    override val genreIds: List<Int>
) : Media() {

}