// To parse the JSON, install Klaxon and do:
//
//   val clientError = ClientError.fromJson(jsonString)
//   val event = Event.fromJson(jsonString)
//   val eventTarget = EventTarget.fromJson(jsonString)
//   val error = Error.fromJson(jsonString)

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
    .convert(JsonObject::class, { it.obj!! },             { it.toJsonString() })
    .convert(Message::class,    { Message.fromJson(it) }, { it.toJson() }, true)

data class ClientError (
    val column: Double? = null;

    @Json(name = "created_at")
    val createdAt: String;

    val error: Error? = null;
    val id: String;
    val line: Double? = null;
    val message: Message;
    val url: String? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<ClientError>(json)
    }
}

data class Error (
    val message: String;
    val name: String;
    val stack: String? = null;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Error>(json)
    }
}

sealed class Message {
    class EventValue(val value: Event)   : Message()
    class StringValue(val value: String) : Message()

    public fun toJson(): String = klaxon.toJsonString(when (this) {
        is EventValue  -> this.value
        is StringValue -> this.value
    })

    companion object {
        public fun fromJson(jv: JsonValue): Message = when (jv.inside) {
            is JsonObject -> EventValue(jv.obj?.let { klaxon.parseFromJsonObject<Event>(it) }!!)
            is String     -> StringValue(jv.string!!)
            else          -> throw IllegalArgumentException()
        }
    }
}

data class Event (
    @Json(name = "AT_TARGET")
    val atTarget: Double;

    val bubbles: Boolean;

    @Json(name = "BUBBLING_PHASE")
    val bubblingPhase: Double;

    val cancelable: Boolean;
    val cancelBubble: Boolean;

    @Json(name = "CAPTURING_PHASE")
    val capturingPhase: Double;

    val composed: Boolean;
    val currentTarget: EventTarget? = null;
    val defaultPrevented: Boolean;
    val eventPhase: Double;
    val isTrusted: Boolean;

    @Json(name = "NONE")
    val none: Double;

    val returnValue: Boolean;
    val srcElement: EventTarget? = null;
    val target: EventTarget? = null;
    val timeStamp: Double;
    val type: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Event>(json)
    }
}

typealias EventTarget = JsonObject
