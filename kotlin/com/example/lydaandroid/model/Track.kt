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
    val release_date: String,
    val created_at: String,
    val updated_at: String,
    val plays: Int,
    val secretcode: String,
    val monetization: Boolean,
    val price: Double,
    val has_cover: Boolean,
    val processed: Boolean,
    val likes: TrackLikeMetadata? = null,
    val reposts: RepostMetadata? = null,
    val comments: CommentMetadata? = null,
    val user: User? = null
)
