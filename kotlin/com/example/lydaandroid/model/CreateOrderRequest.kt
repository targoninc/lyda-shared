package com.example.lydaandroid.model

data class CreateOrderRequest(
    val type: String, // "album" | "track"
    val paymentProvider: PaymentProvider,
    val orderId: String,
    val entityId: Int
)
