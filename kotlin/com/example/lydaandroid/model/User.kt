package com.example.lydaandroid.model

data class User(
    val id: Integer? = null,
    val username: String,
    val mfa_enabled: Integer? = null,
    val displayname: String,
    val description: String,
    val verified: Integer? = null,
    val created_at: String,
    val updated_at: String? = null,
    val has_avatar: Integer? = null,
    val has_banner: Integer? = null
)
