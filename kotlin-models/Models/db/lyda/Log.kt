// To parse the JSON, install Klaxon and do:
//
//   val log = Log.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Log (
    @Json(name = "correlation_id")
    val correlationID: String;

    val host: String;
    val id: Double;
    val logLevel: Double;
    val message: String;
    val properties: String;
    val stack: String;
    val time: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Log>(json)
    }
}
