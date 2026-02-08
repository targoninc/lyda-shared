// To parse the JSON, install Klaxon and do:
//
//   val follow = Follow.fromJson(jsonString)
//   val userBadge = UserBadge.fromJson(jsonString)
//   val usersetting = Usersetting.fromJson(jsonString)
//   val badge = Badge.fromJson(jsonString)
//   val subscriptionStatus = SubscriptionStatus.fromJson(jsonString)
//   val subscription = Subscription.fromJson(jsonString)
//   val userEmail = UserEmail.fromJson(jsonString)
//   val permission = Permission.fromJson(jsonString)
//   val userTotp = UserTotp.fromJson(jsonString)
//   val publicKey = PublicKey.fromJson(jsonString)
//   val user = User.fromJson(jsonString)
//   val playlistLike = PlaylistLike.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

typealias SubscriptionStatus = Double

data class PlaylistLike (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "playlist_id")
    val playlistID: Double;

    /**
     * Represents a user entity with associated attributes and relationships.
     *
     * The `User` interface extends the `Entity` interface from our search library and defines
     * additional properties
     * related to the user, including information about permissions, subscriptions, settings,
     * badges,
     * security credentials, and activity logs.
     */
    val user: User? = null;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<PlaylistLike>(json)
    }
}

/**
 * Represents a user entity with associated attributes and relationships.
 *
 * The `User` interface extends the `Entity` interface from our search library and defines
 * additional properties
 * related to the user, including information about permissions, subscriptions, settings,
 * badges,
 * security credentials, and activity logs.
 */
data class User (
    val badges: List<Badge>? = null;

    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "deleted_at")
    val deletedAt: String;

    val description: String;
    val displayname: String;

    @Json(name = "email_mfa_code")
    val emailMfaCode: String;

    val emails: List<UserEmail>;
    val following: List<Follow>? = null;
    val follows: List<Follow>? = null;
    val giftedSubscriptions: List<Subscription>? = null;

    @Json(name = "has_avatar")
    val hasAvatar: Boolean;

    @Json(name = "has_banner")
    val hasBanner: Boolean;

    val id: Double;
    val ip: String;
    val lastlogin: String? = null;

    @Json(name = "mfa_enabled")
    val mfaEnabled: Boolean;

    @Json(name = "passkey_user_id")
    val passkeyUserID: String;

    @Json(name = "password_hash")
    val passwordHash: String;

    @Json(name = "password_token")
    val passwordToken: String? = null;

    @Json(name = "password_updated_at")
    val passwordUpdatedAt: String;

    val permissions: List<Permission>? = null;

    @Json(name = "public_keys")
    val publicKeys: List<PublicKey>? = null;

    val secondlastlogin: String? = null;
    val settings: List<Usersetting>? = null;
    val subscription: Subscription? = null;

    @Json(name = "tos_agreed_at")
    val tosAgreedAt: String;

    val totp: List<UserTotp>? = null;

    @Json(name = "updated_at")
    val updatedAt: String;

    val userBadges: List<UserBadge>? = null;
    val username: String;

    @Json(name = "verification_status")
    val verificationStatus: String;

    val verified: Boolean;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<User>(json)
    }
}

data class Badge (
    val description: String;
    val id: Double;
    val name: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Badge>(json)
    }
}

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

data class Follow (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "following_user_id")
    val followingUserID: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Follow>(json)
    }
}

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

data class Permission (
    @Json(name = "created_at")
    val createdAt: String;

    val description: String;
    val id: Double;
    val name: String;

    @Json(name = "updated_at")
    val updatedAt: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Permission>(json)
    }
}

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

data class Usersetting (
    @Json(name = "created_at")
    val createdAt: String;

    val key: String;

    @Json(name = "updated_at")
    val updatedAt: String;

    @Json(name = "user_id")
    val userID: Double;

    val value: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Usersetting>(json)
    }
}

data class UserTotp (
    @Json(name = "created_at")
    val createdAt: String;

    val id: Double;
    val name: String;
    val secret: String;

    @Json(name = "updated_at")
    val updatedAt: String;

    @Json(name = "user_id")
    val userID: Double;

    val verified: Boolean;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<UserTotp>(json)
    }
}

data class UserBadge (
    @Json(name = "badge_id")
    val badgeID: Double;

    @Json(name = "given_at")
    val givenAt: String;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<UserBadge>(json)
    }
}
