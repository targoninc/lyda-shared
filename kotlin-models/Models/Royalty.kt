// To parse the JSON, install Klaxon and do:
//
//   val royalty = Royalty.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Royalty (
    val catalogue: String;
    val count: Double;
    val dataprovider: String;
    val delivery: String;
    val id: Double;
    val isrc: String;
    val label: String;
    val mixver: String;
    val period1: String;
    val period2: String;
    val provider: String;
    val releaseartists: String;
    val releasename: String;
    val royalty: Double;
    val salevoid: String;
    val territory: String;
    val title: String;
    val trackartists: String;
    val type: String;
    val upc: String;

    @Json(name = "updated_at")
    val updatedAt: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Royalty>(json)
    }
}
