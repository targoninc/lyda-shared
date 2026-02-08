// To parse the JSON, install Klaxon and do:
//
//   val statistic = Statistic.fromJson(jsonString)
//   val activityTableName = ActivityTableName.fromJson(jsonString)
//   val typedStatistic = TypedStatistic.fromJson(jsonString)

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
    .convert(ActivityTableName::class, { ActivityTableName.fromValue(it.string!!) }, { "\"${it.value}\"" })

data class TypedStatistic (
    val stats: List<Statistic>;
    val type: ActivityTableName;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<TypedStatistic>(json)
    }
}

data class Statistic (
    val id: Any?;
    val label: String;
    val value: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Statistic>(json)
    }
}

enum class ActivityTableName(val value: String) {
    Albumlikes("albumlikes"),
    Albums("albums"),
    Comments("comments"),
    Follows("follows"),
    Listeninghistory("listeninghistory"),
    Playlistlikes("playlistlikes"),
    Playlists("playlists"),
    Reposts("reposts"),
    Tracklikes("tracklikes"),
    Tracks("tracks");

    companion object {
        public fun fromValue(value: String): ActivityTableName = when (value) {
            "albumlikes"       -> Albumlikes
            "albums"           -> Albums
            "comments"         -> Comments
            "follows"          -> Follows
            "listeninghistory" -> Listeninghistory
            "playlistlikes"    -> Playlistlikes
            "playlists"        -> Playlists
            "reposts"          -> Reposts
            "tracklikes"       -> Tracklikes
            "tracks"           -> Tracks
            else               -> throw IllegalArgumentException()
        }
    }
}
