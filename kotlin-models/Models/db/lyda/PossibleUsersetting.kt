// To parse the JSON, install Klaxon and do:
//
//   val possibleUsersetting = PossibleUsersetting.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class PossibleUsersetting (
    val description: String;
    val name: String;
    val type: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<PossibleUsersetting>(json)
    }
}
