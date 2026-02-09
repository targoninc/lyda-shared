package com.example.lydaandroid.model

import java.util.Date

data class PaypalWebhook(
    val id: String,
    val type: String,
    val received_at: String,
    val content: String,
    val paypal_user_id: String,
    val handled: Boolean,
    val updated_at: Date
)
