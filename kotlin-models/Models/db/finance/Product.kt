// To parse the JSON, install Klaxon and do:
//
//   val product = Product.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Product (
    val available: Boolean;
    val description: String;
    val id: Double;
    val image: String;
    val link: String;
    val name: String;
    val url: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Product>(json)
    }
}
