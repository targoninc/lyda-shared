package com.example.lydaandroid.model

data class User(
    val id: Int? = null,
    val username: String = "",
    val mfa_enabled: Int? = null,
    val displayname: String = "",
    val description: String = "",
    val verified: Int? = null,
    val created_at: String = "",
    val updated_at: String? = null,
    val has_avatar: Int? = null,
    val has_banner: Int? = null
)
