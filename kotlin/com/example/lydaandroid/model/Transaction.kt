package com.example.lydaandroid.model

import java.util.Date

data class Transaction(
    val total: Double,
    val tax: Double,
    val fees: Double,
    val paymentProcessor: String,
    val currency: String,
    val item_id: Int? = null,
    val item_name: String? = null,
    val item_type: String? = null,
    val direction: String, // "in" | "out"
    val date: String,
    val refunded: Double,
    val refundReason: String? = null,
    val refundStatus: String? = null
)
