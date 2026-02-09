package com.example.lydaandroid.model

data class Track(
    val id: Integer? = null,
    val user_id: Integer? = null,
    val title: String,
    val isrc: String,
    val artistname: String,
    val upc: String,
    val visibility: Visibility,
    val credits: String,
    val genre: String,
    val version: String,
    val length: Integer? = null,
    val description: String,
    val release_date: String,
    val created_at: String,
    val updated_at: String,
    val plays: Integer? = null,
    val secretcode: String? = null,
    val monetization: Integer? = null,
    val price: Integer? = null,
    val has_cover: Integer? = null,
    val processed: Integer? = null,
    val likes: TrackLikeMetadata? = null,
    val reposts: RepostMetadata? = null,
    val comments: CommentMetadata? = null,
    val user: User? = null
)
