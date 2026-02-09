package com.example.lydaandroid.model

import java.util.Date

data class Track(
    val id: Int,
    val user_id: Int,
    val title: String,
    val isrc: String,
    val artistname: String,
    val upc: String,
    val visibility: Visibility,
    val credits: String,
    val genre: String,
    val version: String,
    val length: Double,
    val description: String,
    val release_date: Date,
    val created_at: Date,
    val updated_at: Date,
    val plays: Int,
    val secretcode: String,
    val monetization: Boolean,
    val price: Double,
    val has_cover: Boolean,
    val processed: Boolean,
    val likes: InteractionMetadata<TrackLike>? = null,
    val reposts: InteractionMetadata<Repost>? = null,
    val comments: InteractionMetadata<Comment>? = null,
    val user: User? = null
)
