package com.example.cinapp.model

class MediasLibrary(
    var id : Int,
    var mediasLibrary: List<Media>
){
    override fun toString(): String {
        return "MediasLibrary(id=$id, mediasLibrary=$mediasLibrary)"
    }

    //add a media to the library
    fun addMedia(media: Media){
        mediasLibrary += media
    }

    //remove a media from the library
    fun removeMedia(media: Media){
        mediasLibrary -= media
    }

    //get a media from the library
    fun getMedia(media: Media): Media?{
        return mediasLibrary.find { it.id == media.id }
    }

    //get all medias from the library
    fun getAllMedias(): List<Media>{
        return mediasLibrary
    }

    //get all medias from the library
    fun getAllMediasByType(type: String): List<Media>{
        var medias = mutableListOf<Media>()
        for (media in mediasLibrary){
            if (media is Movie && type == "movie"){
                medias.add(media)
            }
            if (media is Serie && type == "serie"){
                medias.add(media)
            }
        }
        return medias
    }
}