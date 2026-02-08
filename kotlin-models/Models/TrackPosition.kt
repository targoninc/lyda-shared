// To parse the JSON, install Klaxon and do:
//
//   val trackPosition = TrackPosition.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class TrackPosition (
    val absolute: Double;
    val relative: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<TrackPosition>(json)
    }
}
