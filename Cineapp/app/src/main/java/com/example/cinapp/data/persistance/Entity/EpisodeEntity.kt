package com.example.cinapp.Room.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "season")
data class EpisodeEntity (
        @PrimaryKey var id: Int,
        var name: String,
        var overview: String,
        var stillPath: String,
        var episodeNumber: Int,
        var seasonNumber: Int,
        val releaseDate: String,
        var voteAverage: Double,
        var voteCount: Int,
        var runtime: Int
)