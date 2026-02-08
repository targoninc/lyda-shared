// To parse the JSON, install Klaxon and do:
//
//   val monthlyEarning = MonthlyEarning.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class MonthlyEarning (
    val amount: Double;

    @Json(name = "generated_at")
    val generatedAt: String;

    val id: Double;
    val month: String;

    @Json(name = "product_id")
    val productID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<MonthlyEarning>(json)
    }
}
