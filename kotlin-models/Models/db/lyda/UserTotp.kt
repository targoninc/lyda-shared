// To parse the JSON, install Klaxon and do:
//
//   val userTotp = UserTotp.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class UserTotp (
    @Json(name = "created_at")
    val createdAt: String;

    val id: Double;
    val name: String;
    val secret: String;

    @Json(name = "updated_at")
    val updatedAt: String;

    @Json(name = "user_id")
    val userID: Double;

    val verified: Boolean;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<UserTotp>(json)
    }
}
