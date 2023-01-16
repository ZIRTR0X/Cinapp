package com.example.cinapp.Room.DAO

import androidx.room.*
import com.example.cinapp.Room.Entity.SerieEntity

@Dao
interface SerieDAO {
    @Query("SELECT * FROM serie")
    fun getAll(): List<SerieEntity>

    @Query("SELECT * FROM serie WHERE id IN (:serieIds)")
    fun loadAllByIds(serieIds: IntArray): List<SerieEntity>

    @Query("SELECT * FROM serie WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): SerieEntity

    @Query("SELECT * FROM serie WHERE id LIKE :id LIMIT 1")
    fun findById(id: Int): SerieEntity

    @Query("SELECT * FROM serie WHERE :genreId IN (genreIds)")
    fun findByGenre(genreId: Int): List<SerieEntity>

    @Query("SELECT * FROM serie WHERE :genreId IN (genreIds)")
    fun findByGenres(genreId: List<Int>): List<SerieEntity>

    @Query("SELECT * FROM serie WHERE :seasonId IN (seasonsIds)")
    fun findBySeason(seasonId: Int): SerieEntity

    @Query("SELECT * FROM serie " +
            "WHERE :episodeId IN (" +
            "SELECT episodesIds FROM season WHERE id IN (" +
            "SELECT seasonsIds FROM serie WHERE :episodeId IN (" +
            "SELECT episodesIds FROM season)))")
    fun findByEpisode(episodeId: Int): SerieEntity


}