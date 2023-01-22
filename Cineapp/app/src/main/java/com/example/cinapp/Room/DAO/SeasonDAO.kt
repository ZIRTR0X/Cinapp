package com.example.cinapp.Room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.cinapp.Room.Entity.SeasonEntity

@Dao
interface SeasonDAO {
    @Query("SELECT * FROM season")
    fun getAll(): List<SeasonEntity>

    @Query("SELECT * FROM season WHERE id = :id ")
    fun getSeasonById(id: Int): SeasonEntity

    @Delete
    fun deleteSeason(season: SeasonEntity)

    //@Query("DELETE FROM season WHERE ")
}