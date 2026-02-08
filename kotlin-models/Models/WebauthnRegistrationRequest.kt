// To parse the JSON, install Klaxon and do:
//
//   val webauthnRegistrationRequest = WebauthnRegistrationRequest.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class WebauthnRegistrationRequest (
    val challenge: String;
    val name: String;
    val registration: Registration;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<WebauthnRegistrationRequest>(json)
    }
}

data class Registration (
    val authenticatorData: String;
    val clientData: String;
    val credential: Credential;
    val user: User;
)

data class Credential (
    val algorithm: String;
    val id: String;
    val publicKey: String;
    val transports: List<String>;
)

data class User (
    val displayName: String;
    val id: String;
    val name: String;
)
