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
//   val trackLike = TrackLike.fromJson(jsonString)
//   val playlistLike = PlaylistLike.fromJson(jsonString)
//   val playlistTrack = PlaylistTrack.fromJson(jsonString)
//   val interactionMetadata = InteractionMetadata.fromJson(jsonString)
//   val repost = Repost.fromJson(jsonString)
//   val comment = Comment.fromJson(jsonString)
//   val visibility = Visibility.fromJson(jsonString)
//   val playlist = Playlist.fromJson(jsonString)
//   val notificationReferenceType = NotificationReferenceType.fromJson(jsonString)
//   val notificationReference = NotificationReference.fromJson(jsonString)
//   val notification = Notification.fromJson(jsonString)
//   val collaboratorType = CollaboratorType.fromJson(jsonString)
//   val trackCollaborator = TrackCollaborator.fromJson(jsonString)
//   val track = Track.fromJson(jsonString)
//   val albumTrack = AlbumTrack.fromJson(jsonString)
//   val album = Album.fromJson(jsonString)
//   val feedType = FeedType.fromJson(jsonString)
//   val playingFrom = PlayingFrom.fromJson(jsonString)
//   val interactionMetadataTrackLike = InteractionMetadataTrackLike.fromJson(jsonString)
//   val interactionMetadataRepost = InteractionMetadataRepost.fromJson(jsonString)
//   val interactionMetadataComment = InteractionMetadataComment.fromJson(jsonString)
//   val interactionMetadataT = InteractionMetadataT.fromJson(jsonString)
//   val t = T.fromJson(jsonString)

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
    .convert(JsonObject::class,                { it.obj!! },                                         { it.toJsonString() })
    .convert(FeedType::class,                  { FeedType.fromValue(it.string!!) },                  { "\"${it.value}\"" })
    .convert(Visibility::class,                { Visibility.fromValue(it.string!!) },                { "\"${it.value}\"" })
    .convert(NotificationReferenceType::class, { NotificationReferenceType.fromValue(it.string!!) }, { "\"${it.value}\"" })
    .convert(Type::class,                      { Type.fromValue(it.string!!) },                      { "\"${it.value}\"" })

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

data class InteractionMetadataT (
    val count: Double? = null;
    val interacted: Boolean? = null;
    val list: List<T>? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<InteractionMetadataT>(json)
    }
}

typealias T = JsonObject

enum class FeedType(val value: String) {
    AlbumTracks("albumTracks"),
    AutoQueue("autoQueue"),
    BoughtTracks("boughtTracks"),
    Explore("explore"),
    Following("following"),
    History("history"),
    LikedTracks("likedTracks"),
    PlaylistTracks("playlistTracks"),
    ProfileReposts("profileReposts"),
    ProfileTracks("profileTracks");

    companion object {
        public fun fromValue(value: String): FeedType = when (value) {
            "albumTracks"    -> AlbumTracks
            "autoQueue"      -> AutoQueue
            "boughtTracks"   -> BoughtTracks
            "explore"        -> Explore
            "following"      -> Following
            "history"        -> History
            "likedTracks"    -> LikedTracks
            "playlistTracks" -> PlaylistTracks
            "profileReposts" -> ProfileReposts
            "profileTracks"  -> ProfileTracks
            else             -> throw IllegalArgumentException()
        }
    }
}

/**
 * Represents the source from where media is currently being played.
 */
data class PlayingFrom (
    val entity: Entity? = null;
    val id: Double? = null;
    val name: String;
    val type: Type? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<PlayingFrom>(json)
    }
}

data class Entity (
    @Json(name = "created_at")
    val createdAt: String;

    val description: String;

    @Json(name = "has_cover")
    val hasCover: Boolean;

    val id: Double;
    val likes: InteractionMetadataTrackLike? = null;
    val secretcode: String;
    val title: String;
    val tracks: List<TrackElement>? = null;

    @Json(name = "updated_at")
    val updatedAt: String;

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

    val visibility: Visibility;
    val price: Double? = null;

    @Json(name = "release_date")
    val releaseDate: String? = null;

    val upc: String? = null;
)

data class InteractionMetadataTrackLike (
    val count: Double? = null;
    val interacted: Boolean? = null;
    val list: List<TrackLike>? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<InteractionMetadataTrackLike>(json)
    }
}

data class TrackLike (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "track_id")
    val trackID: Double;

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
        public fun fromJson(json: String) = klaxon.parse<TrackLike>(json)
    }
}

data class TrackElement (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "playlist_id")
    val playlistID: Double? = null;

    val position: Double;
    val track: Track? = null;

    @Json(name = "track_id")
    val trackID: Double;

    @Json(name = "user_id")
    val userID: Double;

    @Json(name = "album_id")
    val albumID: Double? = null;
)

data class Playlist (
    @Json(name = "created_at")
    val createdAt: String;

    val description: String;

    @Json(name = "has_cover")
    val hasCover: Boolean;

    val id: Double;
    val likes: InteractionMetadataTrackLike? = null;
    val secretcode: String;
    val title: String;
    val tracks: List<PlaylistTrack>? = null;

    @Json(name = "updated_at")
    val updatedAt: String;

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

    val visibility: Visibility;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Playlist>(json)
    }
}

data class Comment (
    val canEdit: Boolean? = null;
    val comments: List<Comment>? = null;
    val content: String;

    @Json(name = "created_at")
    val createdAt: String;

    val hidden: Boolean;
    val id: Double;

    @Json(name = "parent_id")
    val parentID: Double;

    @Json(name = "potentially_harmful")
    val potentiallyHarmful: Boolean;

    val track: Track? = null;

    @Json(name = "track_id")
    val trackID: Double;

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
        public fun fromJson(json: String) = klaxon.parse<Comment>(json)
    }
}

data class InteractionMetadataComment (
    val count: Double? = null;
    val interacted: Boolean? = null;
    val list: List<Comment>? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<InteractionMetadataComment>(json)
    }
}

data class TrackCollaborator (
    val approved: Boolean;

    @Json(name = "collab_type")
    val collabType: CollaboratorType? = null;

    @Json(name = "created_at")
    val createdAt: String;

    val denied: Boolean;
    val track: Track? = null;

    @Json(name = "track_id")
    val trackID: Double;

    val type: Double;

    @Json(name = "updated_at")
    val updatedAt: String;

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
        public fun fromJson(json: String) = klaxon.parse<TrackCollaborator>(json)
    }
}

data class AlbumTrack (
    @Json(name = "album_id")
    val albumID: Double;

    @Json(name = "created_at")
    val createdAt: String;

    val position: Double;
    val track: Track? = null;

    @Json(name = "track_id")
    val trackID: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<AlbumTrack>(json)
    }
}

data class Album (
    @Json(name = "created_at")
    val createdAt: String;

    val description: String;

    @Json(name = "has_cover")
    val hasCover: Boolean;

    val id: Double;
    val likes: InteractionMetadataTrackLike? = null;
    val price: Double;

    @Json(name = "release_date")
    val releaseDate: String;

    val secretcode: String;
    val title: String;
    val tracks: List<AlbumTrack>? = null;
    val upc: String;

    @Json(name = "updated_at")
    val updatedAt: String;

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

    val visibility: Visibility;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Album>(json)
    }
}

data class Track (
    val albums: List<Album>? = null;
    val artistname: String;
    val collab: TrackCollaborator? = null;
    val collaborators: List<TrackCollaborator>? = null;
    val comments: InteractionMetadataComment? = null;

    @Json(name = "created_at")
    val createdAt: String;

    val credits: String;
    val description: String;

    @Json(name = "file_fingerprint")
    val fileFingerprint: String? = null;

    @Json(name = "file_hash")
    val fileHash: String? = null;

    val genre: String;

    @Json(name = "has_cover")
    val hasCover: Boolean;

    val id: Double;
    val isrc: String;
    val length: Double;
    val likes: InteractionMetadataTrackLike? = null;

    @Json(name = "loudness_data")
    val loudnessData: String;

    val monetization: Boolean;
    val notifications: List<Notification>? = null;
    val playlists: List<Playlist>? = null;
    val plays: Double;
    val price: Double;
    val processed: Boolean;

    @Json(name = "release_date")
    val releaseDate: String;

    val repost: Repost? = null;

    @Json(name = "repost_user_id")
    val repostUserID: Double? = null;

    val reposts: InteractionMetadataRepost? = null;
    val secretcode: String;
    val title: String;
    val upc: String;

    @Json(name = "updated_at")
    val updatedAt: String;

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

    val version: String;
    val versionid: Double;
    val visibility: Visibility;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Track>(json)
    }
}

data class PlaylistTrack (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "playlist_id")
    val playlistID: Double;

    val position: Double;
    val track: Track? = null;

    @Json(name = "track_id")
    val trackID: Double;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<PlaylistTrack>(json)
    }
}

enum class Visibility(val value: String) {
    Private("private"),
    Public("public");

    companion object {
        public fun fromValue(value: String): Visibility = when (value) {
            "private" -> Private
            "public"  -> Public
            else      -> throw IllegalArgumentException()
        }
    }
}

data class CollaboratorType (
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
        public fun fromJson(json: String) = klaxon.parse<CollaboratorType>(json)
    }
}

data class Notification (
    @Json(name = "created_at")
    val createdAt: String;

    val id: Double;

    @Json(name = "is_read")
    val isRead: Boolean;

    val message: String;
    val references: List<NotificationReference>? = null;

    @Json(name = "search_key")
    val searchKey: String;

    @Json(name = "track_id")
    val trackID: Double;

    val type: String;

    @Json(name = "user_id")
    val userID: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Notification>(json)
    }
}

/**
 * Represents a reference for a notification.
 *
 * This interface defines the structure of a notification reference object,
 * which includes properties to identify and optionally associate an object with the
 * notification.
 */
data class NotificationReference (
    val id: Double;

    @Json(name = "object")
    val notificationReferenceObject: Any? = null;

    val type: NotificationReferenceType;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<NotificationReference>(json)
    }
}

/**
 * Represents the different types of notification references. These are actually stored in
 * the message.
 */
enum class NotificationReferenceType(val value: String) {
    A("a"),
    P("p"),
    T("t"),
    U("u");

    companion object {
        public fun fromValue(value: String): NotificationReferenceType = when (value) {
            "a"  -> A
            "p"  -> P
            "t"  -> T
            "u"  -> U
            else -> throw IllegalArgumentException()
        }
    }
}

data class Repost (
    @Json(name = "created_at")
    val createdAt: String;

    @Json(name = "track_id")
    val trackID: Double;

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
        public fun fromJson(json: String) = klaxon.parse<Repost>(json)
    }
}

data class InteractionMetadataRepost (
    val count: Double? = null;
    val interacted: Boolean? = null;
    val list: List<Repost>? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<InteractionMetadataRepost>(json)
    }
}

enum class Type(val value: String) {
    Album("album"),
    AlbumTracks("albumTracks"),
    AutoQueue("autoQueue"),
    BoughtTracks("boughtTracks"),
    Explore("explore"),
    Following("following"),
    History("history"),
    LikedTracks("likedTracks"),
    Playlist("playlist"),
    PlaylistTracks("playlistTracks"),
    ProfileReposts("profileReposts"),
    ProfileTracks("profileTracks");

    companion object {
        public fun fromValue(value: String): Type = when (value) {
            "album"          -> Album
            "albumTracks"    -> AlbumTracks
            "autoQueue"      -> AutoQueue
            "boughtTracks"   -> BoughtTracks
            "explore"        -> Explore
            "following"      -> Following
            "history"        -> History
            "likedTracks"    -> LikedTracks
            "playlist"       -> Playlist
            "playlistTracks" -> PlaylistTracks
            "profileReposts" -> ProfileReposts
            "profileTracks"  -> ProfileTracks
            else             -> throw IllegalArgumentException()
        }
    }
}
