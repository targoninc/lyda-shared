// To parse the JSON, install Klaxon and do:
//
//   val billingHistory = BillingHistory.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class BillingHistory (
    val amount: Double;

    @Json(name = "billing_type")
    val billingType: String;

    @Json(name = "created_at")
    val createdAt: String;

    val id: Double;

    @Json(name = "product_id")
    val productID: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<BillingHistory>(json)
    }
}
