package com.example.cinapp.data.persistance.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ListIntConverter {
    @TypeConverter
    fun fromString(value: String): List<Int> {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, Int::class.java)
        val adapter = moshi.adapter<List<Int>>(type)
        return adapter.fromJson(value) ?: emptyList()
    }

    @TypeConverter
    fun fromList(list: List<Int>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, Int::class.java)
        val adapter = moshi.adapter<List<Int>>(type)
        return adapter.toJson(list)
    }
}