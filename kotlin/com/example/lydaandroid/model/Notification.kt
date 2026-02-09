package com.example.lydaandroid.model

import java.util.Date

data class Notification(
    val id: Int,
    val user_id: Int,
    val track_id: Int? = null,
    val type: String,
    val search_key: String,
    val message: String,
    val is_read: Boolean,
    val created_at: Date,
    val references: List<NotificationReference>? = null
)
