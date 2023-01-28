package com.example.cinapp.Request

import com.example.cinapp.model.Media
import com.example.cinapp.model.Movie
import com.example.cinapp.model.Serie

class MediaMapper {
    fun searchMapToMedia(mediaResponse: MediaResponse): Media {
        return when (mediaResponse.media_type) {
            "movie" -> searchMapToMovie(mediaResponse)
            "tv" -> searchMapToSerie(mediaResponse)
            else -> throw IllegalArgumentException("Invalid media type")
        }
    }

    private fun searchMapToMovie(mediaResponse: MediaResponse): Movie {
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
            originCountry = mediaResponse.origin_country
        )
    }

    private fun searchMapToSerie(mediaResponse: MediaResponse): Serie {
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
            originCountry = mediaResponse.origin_country
            //seasons = mediaResponse.seasons,
            //numberOfSeasons = mediaResponse.numberOfSeasons,
            //numberOfEpisodes = mediaResponse.numberOfEpisodes
        )
    }
}
