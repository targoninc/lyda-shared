package com.example.lydaandroid.model

data class Log(
    val id: Int,
    val correlation_id: String,
    val time: String,
    val host: String,
    val stack: String,
    val logLevel: Int,
    val message: String,
    val properties: String
)
