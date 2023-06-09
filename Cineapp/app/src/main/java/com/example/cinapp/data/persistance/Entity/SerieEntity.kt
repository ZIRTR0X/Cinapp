package com.example.cinapp.data.persistance.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "serie")
data class SerieEntity (
    @PrimaryKey val id: Int,
    val name: String,
    val backdropPath: String,
    val releaseDate: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    var isView: Boolean
)