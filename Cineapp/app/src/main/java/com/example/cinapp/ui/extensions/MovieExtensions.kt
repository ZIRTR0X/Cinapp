package com.example.cinapp.ui.extensions

import com.example.cinapp.data.persistance.Entity.MovieEntity
import com.example.cinapp.model.Movie

class MovieExtensions {
    companion object{

        fun toMovie(movieEntity: MovieEntity): Movie {
            return Movie(
                null,
                movieEntity.id,
                movieEntity.name,
                movieEntity.backdropPath,
                movieEntity.releaseDate,
                movieEntity.originCountry,
                movieEntity.originalLanguage,
                movieEntity.originalName,
                movieEntity.overview,
                movieEntity.popularity,
                movieEntity.posterPath,
                movieEntity.voteAverage,
                movieEntity.voteCount,
                null,
                movieEntity.isView
            )
        }

        fun toMovieEntity(movie: Movie): MovieEntity {
            return MovieEntity(
                movie.id,
                movie.title?: "",
                movie.backdropPath?: "",
                movie.releaseDate?: "",
                movie.originCountry?: listOf(),
                movie.originalLanguage?: "",
                movie.originalName?: "",
                movie.overview?: "",
                movie.popularity?: 0.0,
                movie.posterPath?: "",
                movie.voteAverage?: 0.0,
                movie.voteCount?: 0,
                movie.isView?: false
            )
        }
    }
}
