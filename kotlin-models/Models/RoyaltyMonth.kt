// To parse the JSON, install Klaxon and do:
//
//   val royaltyMonth = RoyaltyMonth.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class RoyaltyMonth (
    val approved: Boolean;
    val artistRoyalties: Double;
    val calculated: Boolean;
    val hasEarnings: Boolean;
    val month: Double;
    val saleEarnings: Double;
    val streamingEarnings: Double;
    val trackRoyalties: Double;
    val year: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<RoyaltyMonth>(json)
    }
}
