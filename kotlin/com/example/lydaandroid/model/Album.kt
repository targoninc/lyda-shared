package com.example.lydaandroid.model

import java.util.Date

data class Album(
    val id: Int,
    val user_id: Int,
    val title: String,
    val description: String,
    val upc: String,
    val release_date: Date,
    val created_at: Date,
    val updated_at: Date,
    val visibility: Visibility,
    val secretcode: String,
    val has_cover: Boolean,
    val price: Double,
    val likes: InteractionMetadata<Any>? = null,
    val user: User? = null
)
