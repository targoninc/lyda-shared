// To parse the JSON, install Klaxon and do:
//
//   val notificationReferenceType = NotificationReferenceType.fromJson(jsonString)
//   val notificationReference = NotificationReference.fromJson(jsonString)
//   val notification = Notification.fromJson(jsonString)

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
    .convert(NotificationReferenceType::class, { NotificationReferenceType.fromValue(it.string!!) }, { "\"${it.value}\"" })

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
