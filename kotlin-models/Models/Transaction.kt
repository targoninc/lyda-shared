// To parse the JSON, install Klaxon and do:
//
//   val transaction = Transaction.fromJson(jsonString)

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
    .convert(Direction::class, { Direction.fromValue(it.string!!) }, { "\"${it.value}\"" })

data class Transaction (
    val currency: String;
    val date: String;
    val direction: Direction;
    val fees: Double;

    @Json(name = "item_id")
    val itemID: Double? = null;

    @Json(name = "item_name")
    val itemName: String? = null;

    @Json(name = "item_type")
    val itemType: String? = null;

    val paymentProcessor: String;
    val refunded: Double;
    val refundReason: String? = null;
    val refundStatus: String? = null;
    val tax: Double;
    val total: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Transaction>(json)
    }
}

enum class Direction(val value: String) {
    In("in"),
    Out("out");

    companion object {
        public fun fromValue(value: String): Direction = when (value) {
            "in"  -> In
            "out" -> Out
            else  -> throw IllegalArgumentException()
        }
    }
}
