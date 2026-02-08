// To parse the JSON, install Klaxon and do:
//
//   val userPermission = UserPermission.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class UserPermission (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "permission_id")
    val permissionID: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<UserPermission>(json)
    }
}
