package com.example.cinapp.ui.extensions

import com.example.cinapp.data.persistance.Entity.SerieEntity
import com.example.cinapp.model.Serie

class SerieExtensions {
    companion object {
        fun toSerieEntity(serie: Serie): SerieEntity {
            return SerieEntity(
                serie.id,
                serie.title?: "",
                serie.backdropPath?: "",
                serie.releaseDate?: "",
                serie.originCountry?: listOf(),
                serie.originalLanguage?: "",
                serie.originalName?: "",
                serie.overview?: "",
                serie.popularity?: 0.0,
                serie.posterPath?: "",
                serie.voteAverage?: 0.0,
                serie.voteCount?: 0,
                serie.isView?: false
            )
        }

        fun toSerie(serieEntity: SerieEntity): Serie {
            return Serie(
                null,
                serieEntity.id,
                serieEntity.name,
                serieEntity.backdropPath,
                serieEntity.releaseDate,
                serieEntity.originCountry,
                serieEntity.originalLanguage,
                serieEntity.originalName,
                serieEntity.overview,
                serieEntity.popularity,
                serieEntity.posterPath,
                serieEntity.voteAverage,
                serieEntity.voteCount,
                null,
                serieEntity.isView
            )
        }
    }
}