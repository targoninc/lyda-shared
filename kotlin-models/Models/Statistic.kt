// To parse the JSON, install Klaxon and do:
//
//   val statistic = Statistic.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Statistic (
    val id: Any?;
    val label: String;
    val value: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Statistic>(json)
    }
}
