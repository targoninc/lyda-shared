package com.example.lydaandroid.model

data class ActionLog(
    val id: Int,
    val user_id: Int,
    val action_name: String,
    val actioned_user_id: Int? = null,
    val additional_info: String? = null,
    val created_at: String
)
