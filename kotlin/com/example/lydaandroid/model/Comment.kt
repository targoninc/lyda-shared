package com.example.lydaandroid.model

import java.util.Date

data class Comment(
    val id: Int,
    val parent_id: Int? = null,
    val track_id: Int,
    val user_id: Int,
    val content: String,
    val created_at: String,
    val potentially_harmful: Boolean,
    val hidden: Boolean,
    val comments: List<Comment>? = null,
    val user: User? = null,
    val track: Track? = null,
    val canEdit: Boolean? = null
)
