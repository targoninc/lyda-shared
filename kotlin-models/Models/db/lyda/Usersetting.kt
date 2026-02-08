// To parse the JSON, install Klaxon and do:
//
//   val usersetting = Usersetting.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Usersetting (
    @Json(name = "created_at")
    val createdAt: String;

    val key: String;

    @Json(name = "updated_at")
    val updatedAt: String;

    @Json(name = "user_id")
    val userID: Double;

    val value: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Usersetting>(json)
    }
}
