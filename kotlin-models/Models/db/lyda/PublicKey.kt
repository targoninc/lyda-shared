// To parse the JSON, install Klaxon and do:
//
//   val publicKey = PublicKey.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class PublicKey (
    val algorithm: String;

    @Json(name = "backed_up")
    val backedUp: Boolean;

    @Json(name = "created_at")
    val createdAt: String;

    val id: String;

    @Json(name = "key_id")
    val keyID: String;

    val name: String;

    @Json(name = "passkey_user_id")
    val passkeyUserID: String;

    @Json(name = "public_key")
    val publicKey: String;

    val transports: String;

    @Json(name = "updated_at")
    val updatedAt: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<PublicKey>(json)
    }
}
