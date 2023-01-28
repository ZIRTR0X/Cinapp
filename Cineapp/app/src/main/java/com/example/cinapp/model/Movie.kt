package com.example.cinapp.model

class Movie(
    adult: Boolean? = null,
    id: Int,
    title: String? = null,
    backdropPath: String? = null,
    releaseDate: String? = null,
    originCountry: List<String>? = null,
    originalLanguage: String? = null,
    originalName: String? = null,
    overview : String? = null,
    popularity: Double? = null,
    posterPath: String? = null,
    voteAverage: Double? = null,
    voteCount: Int? = null,
    genreIds: List<Int>? = null
): Media(
    adult,
    id,
    title,
    backdropPath,
    releaseDate,
    originCountry,
    originalLanguage,
    originalName,
    overview,
    popularity,
    posterPath,
    voteAverage,
    voteCount,
    genreIds
) {
}