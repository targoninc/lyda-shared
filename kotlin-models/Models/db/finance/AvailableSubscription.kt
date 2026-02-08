// To parse the JSON, install Klaxon and do:
//
//   val availableSubscription = AvailableSubscription.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class AvailableSubscription (
    val description: String;
    val id: Double;
    val name: String;

    @Json(name = "plan_id")
    val planID: String;

    @Json(name = "price_per_term")
    val pricePerTerm: Double;

    @Json(name = "product_id")
    val productID: Double;

    val service: String;

    @Json(name = "term_type")
    val termType: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<AvailableSubscription>(json)
    }
}
