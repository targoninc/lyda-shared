// To parse the JSON, install Klaxon and do:
//
//   val notificationReferenceType = NotificationReferenceType.fromJson(jsonString)

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
    .convert(NotificationReferenceType::class, { NotificationReferenceType.fromValue(it.string!!) }, { "\"${it.value}\"" })

/**
 * Represents the different types of notification references. These are actually stored in
 * the message.
 */
enum class NotificationReferenceType(val value: String) {
    A("a"),
    P("p"),
    T("t"),
    U("u");

    companion object {
        public fun fromValue(value: String): NotificationReferenceType = when (value) {
            "a"  -> A
            "p"  -> P
            "t"  -> T
            "u"  -> U
            else -> throw IllegalArgumentException()
        }
    }
}
