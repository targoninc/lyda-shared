// To parse the JSON, install Klaxon and do:
//
//   val paypalWebhook = PaypalWebhook.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class PaypalWebhook (
    val content: String;
    val handled: Boolean;
    val id: String;

    @Json(name = "paypal_user_id")
    val paypalUserID: String;

    @Json(name = "received_at")
    val receivedAt: String;

    val type: String;

    @Json(name = "updated_at")
    val updatedAt: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<PaypalWebhook>(json)
    }
}
