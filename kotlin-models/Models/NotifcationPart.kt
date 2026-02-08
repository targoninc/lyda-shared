// To parse the JSON, install Klaxon and do:
//
//   val notificationPart = NotificationPart.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private fun <T> Klaxon.convert(k: kotlin.reflect.KClass<*>, fromJson: (JsonValue) -> T, toJson: (T) -> String, isUnion: Boolean = false) =
    this.converter(object: Converter {
        @Suppress("UNCHECKED_CAST")
        override fun toJson(value: Any)        = toJson(value as T)
        override fun fromJson(jv: JsonValue)   = fromJson(jv) as Any
        override fun canConvert(cls: Class<*>) = cls == k.java || (isUnion && cls.superclass == k.java)
    })

private val klaxon = Klaxon()
    .convert(Type::class, { Type.fromValue(it.string!!) }, { "\"${it.value}\"" })

/**
 * Represents a part of a notification that can be displayed as a separate component
 */
data class NotificationPart (
    val id: Double? = null;
    val text: String? = null;
    val type: Type;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<NotificationPart>(json)
    }
}

enum class Type(val value: String) {
    Album("album"),
    Playlist("playlist"),
    Profile("profile"),
    Track("track");

    companion object {
        public fun fromValue(value: String): Type = when (value) {
            "album"    -> Album
            "playlist" -> Playlist
            "profile"  -> Profile
            "track"    -> Track
            else       -> throw IllegalArgumentException()
        }
    }
}
