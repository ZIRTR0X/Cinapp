package com.example.cinapp.model

import android.os.Parcel
import android.os.Parcelable

open class Media (
    val adult: Boolean? = null,
    val id: Int,
    val title: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val originCountry: List<String>? = null,
    val originalLanguage: String? = null,
    val originalName: String? = null,
    val overview : String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null,
    val genreIds: List<Int>? = null,
    var isView: Boolean? = null
        ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("genreIds"),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(adult)
        parcel.writeInt(id)
        parcel.writeString(this.title)
        parcel.writeString(backdropPath)
        parcel.writeString(releaseDate)
        parcel.writeStringList(originCountry)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalName)
        parcel.writeString(overview)
        parcel.writeValue(popularity)
        parcel.writeString(posterPath)
        parcel.writeValue(voteAverage)
        parcel.writeValue(voteCount)
        parcel.writeValue(isView)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }
}