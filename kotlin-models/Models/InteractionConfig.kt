// To parse the JSON, install Klaxon and do:
//
//   val interactionConfig = InteractionConfig.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class InteractionConfig (
    val icons: Icons;
    val optionalOptions: List<String>? = null;
    val requiredOptions: List<String>? = null;
    val toggleable: Boolean? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<InteractionConfig>(json)
    }
}

data class Icons (
    val default: String;
    val interacted: String;
)
