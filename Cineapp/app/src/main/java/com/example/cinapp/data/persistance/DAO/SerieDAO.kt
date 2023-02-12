package com.example.cinapp.data.persistance.DAO

import androidx.room.*
import com.example.cinapp.data.persistance.Entity.MovieEntity
import com.example.cinapp.data.persistance.Entity.SerieEntity

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

/*    @Query("SELECT * FROM serie WHERE :genreId IN (genreIds)")
    fun findByGenre(genreId: Int): List<SerieEntity>

    @Query("SELECT * FROM serie WHERE :genreId IN (genreIds)")
    fun findByGenres(genreId: List<Int>): List<SerieEntity>*/

    @Query("SELECT * FROM serie WHERE id = :id")
    fun getById(id: Int): SerieEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(serie: SerieEntity)

    @Delete
    fun delete(serie: SerieEntity)

    @Update
    fun updateSerie(serie: SerieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg series: SerieEntity)

    @Query("DELETE FROM serie")
    fun deleteAll()

    @Query("DELETE FROM serie WHERE id LIKE :id")
    fun deleteById(id: Int)

}