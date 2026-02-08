// To parse the JSON, install Klaxon and do:
//
//   val theme = Theme.fromJson(jsonString)

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
    .convert(Theme::class, { Theme.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class Theme(val value: String) {
    Dark("dark"),
    Flexoki("flexoki"),
    Light("light");

    companion object {
        public fun fromValue(value: String): Theme = when (value) {
            "dark"    -> Dark
            "flexoki" -> Flexoki
            "light"   -> Light
            else      -> throw IllegalArgumentException()
        }
    }
}
