package com.example.cinapp.api

import com.example.cinapp.api.dto.MediaResponse
import com.example.cinapp.model.Media
import com.example.cinapp.model.Movie
import com.example.cinapp.model.Serie

class MediaMapper {
    fun searchMapToMedia(mediaResponse: MediaResponse): Media? {
        return when (mediaResponse.media_type) {
            "movie" -> mapToMovie(mediaResponse)
            "tv" -> mapToSerie(mediaResponse)
            else -> return null
        }
    }

     fun mapToMovie(mediaResponse: MediaResponse): Movie {
        return Movie(
            id = mediaResponse.id,
            title = mediaResponse.title,
            overview = mediaResponse.overview,
            posterPath = mediaResponse.poster_path,
            releaseDate = mediaResponse.release_date,
            genreIds = mediaResponse.genre_ids,
            popularity = mediaResponse.popularity,
            voteAverage = mediaResponse.vote_average,
            voteCount = mediaResponse.vote_count,
            adult = mediaResponse.adult,
            backdropPath = mediaResponse.backdrop_path,
            originalLanguage = mediaResponse.original_language,
            originalName = mediaResponse.original_title,
            originCountry = mediaResponse.origin_country,
            isView = false
        )
    }

    fun mapToSerie(mediaResponse: MediaResponse): Serie {
        return Serie(
            id = mediaResponse.id,
            title = mediaResponse.name,
            overview = mediaResponse.overview,
            posterPath = mediaResponse.poster_path,
            releaseDate = mediaResponse.first_air_date,
            genreIds = mediaResponse.genre_ids,
            popularity = mediaResponse.popularity,
            voteAverage = mediaResponse.vote_average,
            voteCount = mediaResponse.vote_count,
            adult = mediaResponse.adult,
            backdropPath = mediaResponse.backdrop_path,
            originalLanguage = mediaResponse.original_language,
            originalName = mediaResponse.original_name,
            originCountry = mediaResponse.origin_country,
            isView = false
        )
    }
}
