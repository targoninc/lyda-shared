// To parse the JSON, install Klaxon and do:
//
//   val mfaOption = MfaOption.fromJson(jsonString)

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
    .convert(MfaOption::class, { MfaOption.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class MfaOption(val value: String) {
    Email("email"),
    Totp("totp"),
    Webauthn("webauthn");

    companion object {
        public fun fromValue(value: String): MfaOption = when (value) {
            "email"    -> Email
            "totp"     -> Totp
            "webauthn" -> Webauthn
            else       -> throw IllegalArgumentException()
        }
    }
}
