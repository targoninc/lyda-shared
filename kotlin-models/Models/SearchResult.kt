// To parse the JSON, install Klaxon and do:
//
//   val searchResult = SearchResult.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class SearchResult (
    val display: String;
    val exactMatch: Boolean;
    val hasImage: Boolean? = null;
    val id: Double;
    val subtitle: String? = null;
    val type: String;
    val url: String;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<SearchResult>(json)
    }
}
