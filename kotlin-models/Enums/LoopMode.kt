// To parse the JSON, install Klaxon and do:
//
//   val loopMode = LoopMode.fromJson(jsonString)

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
    .convert(LoopMode::class, { LoopMode.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class LoopMode(val value: String) {
    Context("context"),
    Off("off"),
    Single("single");

    companion object {
        public fun fromValue(value: String): LoopMode = when (value) {
            "context" -> Context
            "off"     -> Off
            "single"  -> Single
            else      -> throw IllegalArgumentException()
        }
    }
}
