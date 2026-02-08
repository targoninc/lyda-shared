// To parse the JSON, install Klaxon and do:
//
//   val streamingQuality = StreamingQuality.fromJson(jsonString)

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
    .convert(StreamingQuality::class, { StreamingQuality.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class StreamingQuality(val value: String) {
    H("h"),
    L("l"),
    M("m");

    companion object {
        public fun fromValue(value: String): StreamingQuality = when (value) {
            "h"  -> H
            "l"  -> L
            "m"  -> M
            else -> throw IllegalArgumentException()
        }
    }
}
