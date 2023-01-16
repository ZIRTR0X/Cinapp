package com.example.cinapp.model

class Season(
    var id: Int,
    var name: String,
    var overview: String,
    var posterPath: String,
    var seasonNumber: Int,
    var episodes: List<Episode>
) {

}