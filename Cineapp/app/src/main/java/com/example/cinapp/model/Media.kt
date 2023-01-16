package com.example.cinapp.model

abstract class Media {
    abstract val id: Int
    abstract val name: String
    abstract val backdropPath: String
    abstract val releaseDate: String
    abstract val originCountry: List<String>
    abstract val originalLanguage: String
    abstract val originalName: String
    abstract val overview : String
    abstract val popularity: Double
    abstract val posterPath: String
    abstract val voteAverage: Double
    abstract val voteCount: Int
    abstract val genreIds: List<Int>
}