// To parse the JSON, install Klaxon and do:
//
//   val paymentProvider = PaymentProvider.fromJson(jsonString)

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
    .convert(PaymentProvider::class, { PaymentProvider.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class PaymentProvider(val value: String) {
    Mollie("mollie"),
    Paypal("paypal"),
    Stripe("stripe");

    companion object {
        public fun fromValue(value: String): PaymentProvider = when (value) {
            "mollie" -> Mollie
            "paypal" -> Paypal
            "stripe" -> Stripe
            else     -> throw IllegalArgumentException()
        }
    }
}
