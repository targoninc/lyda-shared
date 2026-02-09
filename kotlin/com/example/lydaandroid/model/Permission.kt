package com.example.lydaandroid.model

import java.util.Date

data class Permission(
    val id: Int,
    val name: String,
    val description: String,
    val created_at: Date,
    val updated_at: Date
)
