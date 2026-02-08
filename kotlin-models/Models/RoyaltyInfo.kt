// To parse the JSON, install Klaxon and do:
//
//   val boxPlotValues = BoxPlotValues.fromJson(jsonString)
//   val royaltyInfo = RoyaltyInfo.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class RoyaltyInfo (
    val global: Global;
    val personal: Personal;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<RoyaltyInfo>(json)
    }
}

data class Global (
    val counts: Counts;
    val meanTrackRoyalty: Double;
    val paidTotal: Double;
    val totalRoyalties: Double;
    val trackRoyaltyValues: BoxPlotValues;
)

data class Counts (
    val albums: Double;
    val playlists: Double;
    val tracks: Double;
    val users: Double;
)

data class BoxPlotValues (
    val max: Double;
    val median: Double;
    val min: Double;
    val q1: Double;
    val q3: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<BoxPlotValues>(json)
    }
}

data class Personal (
    val available: Double;
    val meanTrackRoyalty: Double;
    val paidTotal: Double;
    val paypalMail: String? = null;
    val totalRoyalties: Double;
    val trackRoyaltyValues: BoxPlotValues;
)
