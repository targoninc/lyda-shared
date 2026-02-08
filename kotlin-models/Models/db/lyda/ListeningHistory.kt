// To parse the JSON, install Klaxon and do:
//
//   val listeningHistory = ListeningHistory.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class ListeningHistory (
    @Json(name = "created_at")
    val createdAt: String;

    val id: Double;
    val quality: String;

    @Json(name = "track_id")
    val trackID: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<ListeningHistory>(json)
    }
}
