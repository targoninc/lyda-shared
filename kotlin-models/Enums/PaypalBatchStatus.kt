// To parse the JSON, install Klaxon and do:
//
//   val paypalBatchStatus = PaypalBatchStatus.fromJson(jsonString)

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
    .convert(PaypalBatchStatus::class, { PaypalBatchStatus.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class PaypalBatchStatus(val value: String) {
    Cancelled("CANCELLED"),
    Denied("DENIED"),
    Pending("PENDING"),
    Processing("PROCESSING"),
    Success("SUCCESS");

    companion object {
        public fun fromValue(value: String): PaypalBatchStatus = when (value) {
            "CANCELLED"  -> Cancelled
            "DENIED"     -> Denied
            "PENDING"    -> Pending
            "PROCESSING" -> Processing
            "SUCCESS"    -> Success
            else         -> throw IllegalArgumentException()
        }
    }
}
