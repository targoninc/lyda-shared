// To parse the JSON, install Klaxon and do:
//
//   val order = Order.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Order (
    @Json(name = "created_at")
    val createdAt: String;

    val currency: String;
    val fees: Double;
    val id: String;

    @Json(name = "item_id")
    val itemID: Double;

    @Json(name = "item_type")
    val itemType: String;

    @Json(name = "payment_provider")
    val paymentProvider: String;

    @Json(name = "provider_order_id")
    val providerOrderID: String;

    @Json(name = "provider_status")
    val providerStatus: String;

    val received: Double;
    val refunded: Double;
    val status: String;
    val taxes: Double;
    val total: Double;

    @Json(name = "updated_at")
    val updatedAt: String;

    @Json(name = "user_id")
    val userID: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Order>(json)
    }
}
