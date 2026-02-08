// To parse the JSON, install Klaxon and do:
//
//   val paypalUser = PaypalUser.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class PaypalUser (
    @Json(name = "email_address")
    val emailAddress: String;

    @Json(name = "given_name")
    val givenName: String;

    @Json(name = "paypal_user_id")
    val paypalUserID: String;

    val surname: String;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<PaypalUser>(json)
    }
}
