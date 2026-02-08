// To parse the JSON, install Klaxon and do:
//
//   val keyValue = KeyValue.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class KeyValue (
    val key: String;
    val value: Any?;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<KeyValue>(json)
    }
}
