// To parse the JSON, install Klaxon and do:
//
//   val interactionMetadata = InteractionMetadata.fromJson(jsonString)
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
    .convert(JsonObject::class, { it.obj!! }, { it.toJsonString() })

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
