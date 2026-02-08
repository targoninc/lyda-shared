// To parse the JSON, install Klaxon and do:
//
//   val subscriptionPayment = SubscriptionPayment.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class SubscriptionPayment (
    val currency: String;

    @Json(name = "external_id")
    val externalID: String;

    val fees: Double;
    val id: Double;

    @Json(name = "payment_processor")
    val paymentProcessor: String;

    @Json(name = "product_id")
    val productID: Double;

    val received: Double;

    @Json(name = "received_at")
    val receivedAt: String;

    @Json(name = "refund_id")
    val refundID: Double? = null;

    val refunded: Double;

    @Json(name = "subscription_id")
    val subscriptionID: Double;

    val succeeded: Boolean;
    val taxes: Double;
    val total: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<SubscriptionPayment>(json)
    }
}
