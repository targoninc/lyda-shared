package com.example.lydaandroid.model

data class ModerationFilter(
    val id: Int? = null,
    val track_id: Int? = null,
    val user_id: Int? = null,
    val content: String? = null,
    val potentially_harmful: Boolean? = null,
    val hidden: Boolean? = null,
    val offset: Int = 0,
    val limit: Int = 100
)
