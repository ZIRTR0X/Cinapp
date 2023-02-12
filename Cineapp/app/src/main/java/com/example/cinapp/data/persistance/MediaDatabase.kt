package com.example.cinapp.data.persistance

import android.app.Application
import androidx.room.*
import com.example.cinapp.CinAppApplication
import com.example.cinapp.data.persistance.DAO.MovieDAO
import com.example.cinapp.data.persistance.DAO.SerieDAO
import com.example.cinapp.data.persistance.Entity.MovieEntity
import com.example.cinapp.data.persistance.Entity.SerieEntity
import com.example.cinapp.data.persistance.converter.ListStringConverter

@Database(entities = [MovieEntity::class, SerieEntity::class], version = 1)
@TypeConverters(ListStringConverter::class)
abstract class MediaDatabase: RoomDatabase() {
    abstract fun movieDAO(): MovieDAO
    abstract fun serieDAO(): SerieDAO

    companion object {
        @Volatile
        private var instance: MediaDatabase? = null
        private lateinit var application: Application

        fun getInstance(): MediaDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        application.applicationContext,
                        MediaDatabase::class.java, "media.db")
                        .build()
                }
            }
            return instance!!
        }

        @JvmStatic
        fun initialize(app: CinAppApplication) {
            if (::application.isInitialized)
                throw RuntimeException("the database must not be initialized twice")

            application = app
        }


        fun destroyInstance() {
            instance = null
        }
    }
}
