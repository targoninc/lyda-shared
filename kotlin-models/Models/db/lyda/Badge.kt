// To parse the JSON, install Klaxon and do:
//
//   val badge = Badge.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Badge (
    val description: String;
    val id: Double;
    val name: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Badge>(json)
    }
}
