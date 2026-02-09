package com.example.lydaandroid.model

import java.util.Date

data class User(
    val id: Int,
    val username: String,
    val mfa_enabled: Boolean,
    val displayname: String,
    val description: String,
    val verified: Boolean,
    val created_at: Date,
    val updated_at: Date,
    val has_avatar: Boolean,
    val has_banner: Boolean
)
