// To parse the JSON, install Klaxon and do:
//
//   val genre = Genre.fromJson(jsonString)

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
    .convert(Genre::class, { Genre.fromValue(it.string!!) }, { "\"${it.value}\"" })

enum class Genre(val value: String) {
    Alternative("alternative"),
    Blues("blues"),
    Classical("classical"),
    Country("country"),
    Dance("dance"),
    Disco("disco"),
    Dubstep("dubstep"),
    Electronic("electronic"),
    Folk("folk"),
    Funk("funk"),
    HipHop("hip-hop"),
    House("house"),
    Indie("indie"),
    Jazz("jazz"),
    Metal("metal"),
    Other("other"),
    Pop("pop"),
    Punk("punk"),
    RB("r&b"),
    Rap("rap"),
    Reggae("reggae"),
    Rock("rock"),
    Soul("soul"),
    Techno("techno"),
    Trance("trance");

    companion object {
        public fun fromValue(value: String): Genre = when (value) {
            "alternative" -> Alternative
            "blues"       -> Blues
            "classical"   -> Classical
            "country"     -> Country
            "dance"       -> Dance
            "disco"       -> Disco
            "dubstep"     -> Dubstep
            "electronic"  -> Electronic
            "folk"        -> Folk
            "funk"        -> Funk
            "hip-hop"     -> HipHop
            "house"       -> House
            "indie"       -> Indie
            "jazz"        -> Jazz
            "metal"       -> Metal
            "other"       -> Other
            "pop"         -> Pop
            "punk"        -> Punk
            "r&b"         -> RB
            "rap"         -> Rap
            "reggae"      -> Reggae
            "rock"        -> Rock
            "soul"        -> Soul
            "techno"      -> Techno
            "trance"      -> Trance
            else          -> throw IllegalArgumentException()
        }
    }
}
