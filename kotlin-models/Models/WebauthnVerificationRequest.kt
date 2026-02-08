// To parse the JSON, install Klaxon and do:
//
//   val webauthnVerificationRequest = WebauthnVerificationRequest.fromJson(jsonString)
//   val authenticationResponseJSON = AuthenticationResponseJSON.fromJson(jsonString)
//   val authenticatorAssertionResponseJSON = AuthenticatorAssertionResponseJSON.fromJson(jsonString)
//   val authenticationExtensionsClientOutputs = AuthenticationExtensionsClientOutputs.fromJson(jsonString)
//   val credentialPropertiesOutput = CredentialPropertiesOutput.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private fun <T> Klaxon.convert(k: kotlin.reflect.KClass<*>, fromJson: (JsonValue) -> T, toJson: (T) -> String, isUnion: Boolean = false) =
    this.converter(object: Converter {
        @Suppress("UNCHECKED_CAST")
        override fun toJson(value: Any)        = toJson(value as T)
        override fun fromJson(jv: JsonValue)   = fromJson(jv) as Any
        override fun canConvert(cls: Class<*>) = cls == k.java || (isUnion && cls.superclass == k.java)
    })

private val klaxon = Klaxon()
    .convert(AuthenticatorAttachment::class, { AuthenticatorAttachment.fromValue(it.string!!) }, { "\"${it.value}\"" })
    .convert(Type::class,                    { Type.fromValue(it.string!!) },                    { "\"${it.value}\"" })

data class WebauthnVerificationRequest (
    val challenge: String;
    val verification: AuthenticationResponseJSON;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<WebauthnVerificationRequest>(json)
    }
}

/**
 * A slightly-modified AuthenticationCredential to simplify working with ArrayBuffers that
 * are Base64URL-encoded in the browser so that they can be sent as JSON to the server.
 *
 * https://w3c.github.io/webauthn/#dictdef-authenticationresponsejson
 */
data class AuthenticationResponseJSON (
    val authenticatorAttachment: AuthenticatorAttachment? = null;
    val clientExtensionResults: AuthenticationExtensionsClientOutputs;
    val id: String;

    @Json(name = "rawId")
    val rawID: String;

    val response: AuthenticatorAssertionResponseJSON;
    val type: Type;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<AuthenticationResponseJSON>(json)
    }
}

enum class AuthenticatorAttachment(val value: String) {
    CrossPlatform("cross-platform"),
    Platform("platform");

    companion object {
        public fun fromValue(value: String): AuthenticatorAttachment = when (value) {
            "cross-platform" -> CrossPlatform
            "platform"       -> Platform
            else             -> throw IllegalArgumentException()
        }
    }
}

data class AuthenticationExtensionsClientOutputs (
    val appid: Boolean? = null;
    val credProps: CredentialPropertiesOutput? = null;
    val hmacCreateSecret: Boolean? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<AuthenticationExtensionsClientOutputs>(json)
    }
}

data class CredentialPropertiesOutput (
    val rk: Boolean? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<CredentialPropertiesOutput>(json)
    }
}

/**
 * A slightly-modified AuthenticatorAssertionResponse to simplify working with ArrayBuffers
 * that
 * are Base64URL-encoded in the browser so that they can be sent as JSON to the server.
 *
 * https://w3c.github.io/webauthn/#dictdef-authenticatorassertionresponsejson
 */
data class AuthenticatorAssertionResponseJSON (
    val authenticatorData: String;
    val clientDataJSON: String;
    val signature: String;
    val userHandle: String? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<AuthenticatorAssertionResponseJSON>(json)
    }
}

enum class Type(val value: String) {
    PublicKey("public-key");

    companion object {
        public fun fromValue(value: String): Type = when (value) {
            "public-key" -> PublicKey
            else         -> throw IllegalArgumentException()
        }
    }
}
