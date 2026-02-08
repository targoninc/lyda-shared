// To parse the JSON, install Klaxon and do:
//
//   val orderStatus = OrderStatus.fromJson(jsonString)

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
    .convert(OrderStatus::class, { OrderStatus.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class OrderStatus(val value: String) {
    Cancelled("cancelled"),
    Fulfilled("fulfilled"),
    Started("started");

    companion object {
        public fun fromValue(value: String): OrderStatus = when (value) {
            "cancelled" -> Cancelled
            "fulfilled" -> Fulfilled
            "started"   -> Started
            else        -> throw IllegalArgumentException()
        }
    }
}
