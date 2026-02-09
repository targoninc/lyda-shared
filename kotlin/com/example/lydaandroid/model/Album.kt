package com.example.lydaandroid.model

import java.util.Date

data class Album(
    val id: Int,
    val user_id: Int,
    val title: String,
    val description: String,
    val upc: String,
    val release_date: String,
    val created_at: String,
    val updated_at: String,
    val visibility: Visibility,
    val secretcode: String,
    val has_cover: Boolean,
    val price: Double,
    val likes: TrackLikeMetadata? = null,
    val user: User? = null
)
