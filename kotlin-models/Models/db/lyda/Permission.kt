// To parse the JSON, install Klaxon and do:
//
//   val permission = Permission.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Permission (
    @Json(name = "created_at")
    val createdAt: String;

    val description: String;
    val id: Double;
    val name: String;

    @Json(name = "updated_at")
    val updatedAt: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Permission>(json)
    }
}
