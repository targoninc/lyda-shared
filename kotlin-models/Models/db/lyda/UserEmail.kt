// To parse the JSON, install Klaxon and do:
//
//   val userEmail = UserEmail.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class UserEmail (
    val email: String;
    val primary: Boolean;

    @Json(name = "user_id")
    val userID: Double;

    @Json(name = "verification_code")
    val verificationCode: String;

    val verified: Boolean;

    @Json(name = "verified_at")
    val verifiedAt: String? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<UserEmail>(json)
    }
}
