package com.example.lydaandroid.model

import java.util.Date

data class CollaboratorType(
    val id: Int,
    val name: String,
    val description: String,
    val created_at: String,
    val updated_at: Date
)
