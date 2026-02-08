// To parse the JSON, install Klaxon and do:
//
//   val follow = Follow.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Follow (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "following_user_id")
    val followingUserID: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Follow>(json)
    }
}
