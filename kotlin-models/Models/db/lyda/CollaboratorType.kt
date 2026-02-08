// To parse the JSON, install Klaxon and do:
//
//   val collaboratorType = CollaboratorType.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class CollaboratorType (
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
        public fun fromJson(json: String) = klaxon.parse<CollaboratorType>(json)
    }
}
