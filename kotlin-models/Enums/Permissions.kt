// To parse the JSON, install Klaxon and do:
//
//   val permissions = Permissions.fromJson(jsonString)

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
    .convert(Permissions::class, { Permissions.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class Permissions(val value: String) {
    CanBan("canBan"),
    CanCalculateRoyalties("canCalculateRoyalties"),
    CanDeleteComments("canDeleteComments"),
    CanDeleteListsOfOthers("canDeleteListsOfOthers"),
    CanDeleteTracksOfOthers("canDeleteTracksOfOthers"),
    CanEditListsOfOthers("canEditListsOfOthers"),
    CanEditTracksOfOthers("canEditTracksOfOthers"),
    CanRefund("canRefund"),
    CanRetriggerContentID("canRetriggerContentID"),
    CanSetPermissions("canSetPermissions"),
    CanTriggerEventHandling("canTriggerEventHandling"),
    CanVerifyUsers("canVerifyUsers"),
    CanViewActionLogs("canViewActionLogs"),
    CanViewLogs("canViewLogs"),
    CanViewPayments("canViewPayments");

    companion object {
        public fun fromValue(value: String): Permissions = when (value) {
            "canBan"                  -> CanBan
            "canCalculateRoyalties"   -> CanCalculateRoyalties
            "canDeleteComments"       -> CanDeleteComments
            "canDeleteListsOfOthers"  -> CanDeleteListsOfOthers
            "canDeleteTracksOfOthers" -> CanDeleteTracksOfOthers
            "canEditListsOfOthers"    -> CanEditListsOfOthers
            "canEditTracksOfOthers"   -> CanEditTracksOfOthers
            "canRefund"               -> CanRefund
            "canRetriggerContentID"   -> CanRetriggerContentID
            "canSetPermissions"       -> CanSetPermissions
            "canTriggerEventHandling" -> CanTriggerEventHandling
            "canVerifyUsers"          -> CanVerifyUsers
            "canViewActionLogs"       -> CanViewActionLogs
            "canViewLogs"             -> CanViewLogs
            "canViewPayments"         -> CanViewPayments
            else                      -> throw IllegalArgumentException()
        }
    }
}
