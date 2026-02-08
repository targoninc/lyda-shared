// To parse the JSON, install Klaxon and do:
//
//   val collabTypes = CollabTypes.fromJson(jsonString)

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
    .convert(CollabTypes::class, { CollabTypes.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class CollabTypes(val value: String) {
    Collaborator("Collaborator"),
    Composer("Composer"),
    Original("Original"),
    Producer("Producer"),
    Remixer("Remixer"),
    Singer("Singer"),
    VisualArtist("Visual artist");

    companion object {
        public fun fromValue(value: String): CollabTypes = when (value) {
            "Collaborator"  -> Collaborator
            "Composer"      -> Composer
            "Original"      -> Original
            "Producer"      -> Producer
            "Remixer"       -> Remixer
            "Singer"        -> Singer
            "Visual artist" -> VisualArtist
            else            -> throw IllegalArgumentException()
        }
    }
}
