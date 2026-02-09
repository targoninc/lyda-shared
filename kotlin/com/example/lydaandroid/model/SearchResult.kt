package com.example.lydaandroid.model

data class SearchResult(
    val id: Int,
    val url: String,
    val exactMatch: Boolean,
    val type: String,
    val display: String,
    val subtitle: String? = null,
    val hasImage: Boolean? = null
)
