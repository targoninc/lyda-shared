package com.example.lydaandroid.model

data class Playlist(
    val id: Int? = null,
    val user_id: Int? = null,
    val title: String = "",
    val description: String = "",
    val created_at: String = "",
    val updated_at: String = "",
    val visibility: Visibility,
    val has_cover: Boolean = false,
    val secretcode: String? = null,
    val user: User? = null,
    val likes: TrackLikeMetadata? = null
)
