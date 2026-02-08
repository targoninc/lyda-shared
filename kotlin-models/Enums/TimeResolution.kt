// To parse the JSON, install Klaxon and do:
//
//   val timeResolution = TimeResolution.fromJson(jsonString)

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
    .convert(TimeResolution::class, { TimeResolution.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class TimeResolution(val value: String) {
    Day("day"),
    Hour("hour"),
    Minute("minute"),
    Month("month"),
    Second("second"),
    Year("year");

    companion object {
        public fun fromValue(value: String): TimeResolution = when (value) {
            "day"    -> Day
            "hour"   -> Hour
            "minute" -> Minute
            "month"  -> Month
            "second" -> Second
            "year"   -> Year
            else     -> throw IllegalArgumentException()
        }
    }
}
