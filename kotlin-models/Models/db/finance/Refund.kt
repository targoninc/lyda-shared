// To parse the JSON, install Klaxon and do:
//
//   val refund = Refund.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Refund (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "external_id")
    val externalID: String;

    @Json(name = "external_provider")
    val externalProvider: String;

    @Json(name = "external_status")
    val externalStatus: String;

    val id: Double;
    val reason: String? = null;

    @Json(name = "updated_at")
    val updatedAt: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Refund>(json)
    }
}
