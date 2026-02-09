package com.example.lydaandroid.model

import java.util.Date

data class Album(
    val id: Int? = null,
    val user_id: Int? = null,
    val title: String = "",
    val description: String = "",
    val upc: String = "",
    val release_date: String = "",
    val created_at: String = "",
    val updated_at: String = "",
    val visibility: String? = "public",
    val secretcode: String? = null,
    val has_cover: Boolean = false,
    val price: Double = 0.0,
    val likes: TrackLikeMetadata? = null,
    val user: User? = null
)