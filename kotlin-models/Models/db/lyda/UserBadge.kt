// To parse the JSON, install Klaxon and do:
//
//   val userBadge = UserBadge.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class UserBadge (
    @Json(name = "badge_id")
    val badgeID: Double;

    @Json(name = "given_at")
    val givenAt: String;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<UserBadge>(json)
    }
}
