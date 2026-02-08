// To parse the JSON, install Klaxon and do:
//
//   val mediaFileType = MediaFileType.fromJson(jsonString)

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
    .convert(MediaFileType::class, { MediaFileType.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class MediaFileType(val value: String) {
    AlbumCover("albumCover"),
    Audio("audio"),
    PlaylistCover("playlistCover"),
    TrackCover("trackCover"),
    UserAvatar("userAvatar"),
    UserBanner("userBanner");

    companion object {
        public fun fromValue(value: String): MediaFileType = when (value) {
            "albumCover"    -> AlbumCover
            "audio"         -> Audio
            "playlistCover" -> PlaylistCover
            "trackCover"    -> TrackCover
            "userAvatar"    -> UserAvatar
            "userBanner"    -> UserBanner
            else            -> throw IllegalArgumentException()
        }
    }
}
