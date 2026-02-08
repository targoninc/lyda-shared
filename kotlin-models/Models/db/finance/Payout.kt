// To parse the JSON, install Klaxon and do:
//
//   val paymentStatus = PaymentStatus.fromJson(jsonString)
//   val payout = Payout.fromJson(jsonString)

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
    .convert(PaymentStatus::class, { PaymentStatus.fromValue(it.string!!) }, { "\"${it.value}\"" })

data class Payout (
    @Json(name = "amount_ct")
    val amountCT: Double;

    @Json(name = "created_at")
    val createdAt: String;

    val id: Double;

    @Json(name = "payout_batch_id")
    val payoutBatchID: String;

    val status: PaymentStatus;

    @Json(name = "updated_at")
    val updatedAt: String;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Payout>(json)
    }
}

enum class PaymentStatus(val value: String) {
    Failed("failed"),
    Paid("paid"),
    Processing("processing"),
    Requested("requested");

    companion object {
        public fun fromValue(value: String): PaymentStatus = when (value) {
            "failed"     -> Failed
            "paid"       -> Paid
            "processing" -> Processing
            "requested"  -> Requested
            else         -> throw IllegalArgumentException()
        }
    }
}
