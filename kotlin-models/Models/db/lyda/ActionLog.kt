// To parse the JSON, install Klaxon and do:
//
//   val actionLog = ActionLog.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class ActionLog (
    @Json(name = "action_name")
    val actionName: String;

    @Json(name = "actioned_user_id")
    val actionedUserID: Double;

    @Json(name = "additional_info")
    val additionalInfo: String;

    @Json(name = "created_at")
    val createdAt: String;

    val id: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<ActionLog>(json)
    }
}
