package com.example.lydaandroid.model

import java.util.Date

data class Playlist(
    val id: Int,
    val user_id: Int,
    val title: String,
    val description: String,
    val created_at: Date,
    val updated_at: Date,
    val visibility: Visibility,
    val has_cover: Boolean,
    val secretcode: String,
    val user: User? = null,
    val likes: InteractionMetadata<Any>? = null
)
