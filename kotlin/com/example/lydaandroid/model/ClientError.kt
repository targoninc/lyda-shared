package com.example.lydaandroid.model

import java.util.Date

data class ClientError(
    val id: String? = null,
    val created_at: Date? = null,
    val message: String,
    val url: String? = null,
    val line: Int? = null,
    val column: Int? = null,
    val error: String? = null
)
