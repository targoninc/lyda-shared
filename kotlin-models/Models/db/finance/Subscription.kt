// To parse the JSON, install Klaxon and do:
//
//   val subscriptionStatus = SubscriptionStatus.fromJson(jsonString)
//   val subscription = Subscription.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

typealias SubscriptionStatus = Double

data class Subscription (
    @Json(name = "cancelled_at")
    val cancelledAt: String;

    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "currency_code")
    val currencyCode: String;

    @Json(name = "external_order_id")
    val externalOrderID: String;

    @Json(name = "external_subscription_id")
    val externalSubscriptionID: String;

    @Json(name = "gifted_by_user_id")
    val giftedByUserID: Double;

    val id: Double;

    @Json(name = "next_billing_time")
    val nextBillingTime: String;

    @Json(name = "outstanding_balance")
    val outstandingBalance: String;

    @Json(name = "previous_subscription")
    val previousSubscription: Double;

    val status: Double;

    @Json(name = "subscription_id")
    val subscriptionID: Double;

    @Json(name = "updated_at")
    val updatedAt: String;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Subscription>(json)
    }
}
