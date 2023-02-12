package com.example.cinapp.data.persistance.Entity

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.cinapp.CinAppApplication
import com.example.cinapp.data.persistance.MediaDatabase

class AppDatabase {
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
            Log.d("MediaDatabase", "getInstance: ${instance.toString()}")
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
