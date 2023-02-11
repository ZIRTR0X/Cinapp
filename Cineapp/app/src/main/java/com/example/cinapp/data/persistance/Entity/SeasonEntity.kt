package com.example.cinapp.data.persistance.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "season")
data class SeasonEntity (
    @PrimaryKey var id: Int,
    var name: String,
    var overview: String,
    var posterPath: String,
    var seasonNumber: Int,
    var episodesIds: List<Int>,
    val releaseDate: String
)