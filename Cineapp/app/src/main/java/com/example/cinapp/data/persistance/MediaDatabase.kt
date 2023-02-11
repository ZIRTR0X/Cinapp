package com.example.cinapp.data.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinapp.data.persistance.DAO.EpisodeDAO
import com.example.cinapp.data.persistance.DAO.MovieDAO
import com.example.cinapp.data.persistance.DAO.SeasonDAO
import com.example.cinapp.data.persistance.DAO.SerieDAO
import com.example.cinapp.data.persistance.Entity.EpisodeEntity
import com.example.cinapp.data.persistance.Entity.MovieEntity
import com.example.cinapp.data.persistance.Entity.SeasonEntity
import com.example.cinapp.data.persistance.Entity.SerieEntity

@Database(entities = [SeasonEntity::class, EpisodeEntity::class, MovieEntity::class, SerieEntity::class], version = 1)
abstract class MediaDatabase: RoomDatabase() {
    abstract fun seasonDAO(): SeasonDAO
    abstract fun episodeDAO(): EpisodeDAO
    abstract fun movieDAO(): MovieDAO
    abstract fun serieDAO(): SerieDAO
}