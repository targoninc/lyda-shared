// To parse the JSON, install Klaxon and do:
//
//   val boxPlotValues = BoxPlotValues.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

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
