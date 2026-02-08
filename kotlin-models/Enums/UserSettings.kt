// To parse the JSON, install Klaxon and do:
//
//   val userSettings = UserSettings.fromJson(jsonString)

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
    .convert(UserSettings::class, { UserSettings.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class UserSettings(val value: String) {
    Language("language"),
    NotificationCollaboration("notification_collaboration"),
    NotificationComment("notification_comment"),
    NotificationFollow("notification_follow"),
    NotificationLike("notification_like"),
    NotificationReply("notification_reply"),
    NotificationRepost("notification_repost"),
    NotificationSale("notification_sale"),
    PaypalMail("paypalMail"),
    PlayFromAutoQueue("playFromAutoQueue"),
    PublicLikes("publicLikes"),
    StreamingQuality("streamingQuality"),
    Theme("theme");

    companion object {
        public fun fromValue(value: String): UserSettings = when (value) {
            "language"                   -> Language
            "notification_collaboration" -> NotificationCollaboration
            "notification_comment"       -> NotificationComment
            "notification_follow"        -> NotificationFollow
            "notification_like"          -> NotificationLike
            "notification_reply"         -> NotificationReply
            "notification_repost"        -> NotificationRepost
            "notification_sale"          -> NotificationSale
            "paypalMail"                 -> PaypalMail
            "playFromAutoQueue"          -> PlayFromAutoQueue
            "publicLikes"                -> PublicLikes
            "streamingQuality"           -> StreamingQuality
            "theme"                      -> Theme
            else                         -> throw IllegalArgumentException()
        }
    }
}
