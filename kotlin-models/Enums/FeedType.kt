// To parse the JSON, install Klaxon and do:
//
//   val feedType = FeedType.fromJson(jsonString)

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
    .convert(FeedType::class, { FeedType.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class FeedType(val value: String) {
    AlbumTracks("albumTracks"),
    AutoQueue("autoQueue"),
    BoughtTracks("boughtTracks"),
    Explore("explore"),
    Following("following"),
    History("history"),
    LikedTracks("likedTracks"),
    PlaylistTracks("playlistTracks"),
    ProfileReposts("profileReposts"),
    ProfileTracks("profileTracks");

    companion object {
        public fun fromValue(value: String): FeedType = when (value) {
            "albumTracks"    -> AlbumTracks
            "autoQueue"      -> AutoQueue
            "boughtTracks"   -> BoughtTracks
            "explore"        -> Explore
            "following"      -> Following
            "history"        -> History
            "likedTracks"    -> LikedTracks
            "playlistTracks" -> PlaylistTracks
            "profileReposts" -> ProfileReposts
            "profileTracks"  -> ProfileTracks
            else             -> throw IllegalArgumentException()
        }
    }
}
