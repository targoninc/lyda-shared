package com.example.lydaandroid.model

import java.util.Date

data class SubscriptionPayment(
    val id: Int,
    val received_at: Date,
    val user_id: Int,
    val product_id: Int,
    val subscription_id: Int,
    val currency: String,
    val payment_processor: String,
    val external_id: String,
    val total: Double,
    val fees: Double,
    val taxes: Double,
    val received: Double,
    val refunded: Double,
    val refund_id: Int? = null,
    val succeeded: Boolean
)
