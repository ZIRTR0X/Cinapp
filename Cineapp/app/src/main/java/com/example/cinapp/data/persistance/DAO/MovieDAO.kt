package com.example.cinapp.data.persistance.DAO

import androidx.room.*
import com.example.cinapp.data.persistance.Entity.MovieEntity

@Dao
interface MovieDAO {

    @Query("SELECT * FROM movie")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE id IN (:movieIds)")
    fun loadAllByIds(movieIds: IntArray): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): MovieEntity

    @Query("SELECT * FROM movie WHERE id LIKE :id LIMIT 1")
    fun findById(id: Int): MovieEntity

  /*  @Query("SELECT * FROM movie WHERE :genreId IN (genreIds)")
    fun findByGenre(genreId: Int): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE :genreId IN (genreIds)")
    fun findByGenres(genreId: List<Int>): List<MovieEntity>*/

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getById(id: Int): MovieEntity

    @Update
    fun updateMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg movies: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity)

    @Delete
    fun delete(movie: MovieEntity)

    @Query("DELETE FROM movie")
    fun deleteAll()

    @Query("DELETE FROM movie WHERE id LIKE :id")
    fun deleteById(id: Int)



}