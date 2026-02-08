// To parse the JSON, install Klaxon and do:
//
//   val userCacheKey = UserCacheKey.fromJson(jsonString)

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
    .convert(UserCacheKey::class, { UserCacheKey.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class UserCacheKey(val value: String) {
    LastTrackID("lastTrackId"),
    LastTrackPosition("lastTrackPosition"),
    LoopMode("loopMode"),
    PlayingFrom("playingFrom"),
    Shuffling("shuffling"),
    Volume("volume");

    companion object {
        public fun fromValue(value: String): UserCacheKey = when (value) {
            "lastTrackId"       -> LastTrackID
            "lastTrackPosition" -> LastTrackPosition
            "loopMode"          -> LoopMode
            "playingFrom"       -> PlayingFrom
            "shuffling"         -> Shuffling
            "volume"            -> Volume
            else                -> throw IllegalArgumentException()
        }
    }
}
