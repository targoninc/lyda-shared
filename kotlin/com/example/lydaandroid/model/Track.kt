package com.example.lydaandroid.model

data class Track(
    val id: Int? = null,
    val user_id: Int? = null,
    val title: String = "",
    val isrc: String = "",
    val artistname: String = "",
    val upc: String = "",
    val visibility: Visibility,
    val credits: String = "",
    val genre: String = "",
    val version: String = "",
    val length: Int? = null,
    val description: String = "",
    val release_date: String = "",
    val created_at: String = "",
    val updated_at: String = "",
    val plays: Int? = null,
    val secretcode: String? = null,
    val monetization: Int? = null,
    val price: Int? = null,
    val has_cover: Int? = null,
    val processed: Int? = null,
    val likes: TrackLikeMetadata? = null,
    val reposts: RepostMetadata? = null,
    val comments: CommentMetadata? = null,
    val user: User? = null
)