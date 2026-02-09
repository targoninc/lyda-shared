package com.example.lydaandroid.model

import java.util.Date

data class Comment(
    val id: Int? = null,
    val parent_id: Int? = null,
    val track_id: Int? = null,
    val user_id: Int? = null,
    val content: String = "",
    val created_at: String = "",
    val potentially_harmful: Boolean = false,
    val hidden: Boolean = false,
    val comments: List<Comment>? = null,
    val user: User? = null,
    val track: Track? = null,
    val canEdit: Boolean? = null
)
