package com.example.cinapp.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinapp.Room.DAO.EpisodeDAO
import com.example.cinapp.Room.DAO.MovieDAO
import com.example.cinapp.Room.DAO.SeasonDAO
import com.example.cinapp.Room.DAO.SerieDAO
import com.example.cinapp.Room.Entity.EpisodeEntity
import com.example.cinapp.Room.Entity.MovieEntity
import com.example.cinapp.Room.Entity.SeasonEntity
import com.example.cinapp.Room.Entity.SerieEntity

@Database(entities = [SeasonEntity::class, EpisodeEntity::class, MovieEntity::class, SerieEntity::class], version = 1)
abstract class MediaDatabase: RoomDatabase() {
    abstract fun seasonDAO(): SeasonDAO
    abstract fun episodeDAO(): EpisodeDAO
    abstract fun movieDAO(): MovieDAO
    abstract fun serieDAO(): SerieDAO
}