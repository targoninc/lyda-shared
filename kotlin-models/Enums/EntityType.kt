// To parse the JSON, install Klaxon and do:
//
//   val entityType = EntityType.fromJson(jsonString)

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
    .convert(EntityType::class, { EntityType.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class EntityType(val value: String) {
    Album("album"),
    Playlist("playlist"),
    Track("track");

    companion object {
        public fun fromValue(value: String): EntityType = when (value) {
            "album"    -> Album
            "playlist" -> Playlist
            "track"    -> Track
            else       -> throw IllegalArgumentException()
        }
    }
}
