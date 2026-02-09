package com.example.lydaandroid.model

import java.util.Date

data class Payout(
    val id: Int,
    val payout_batch_id: String?,
    val user_id: Int,
    val amount_ct: Int,
    val status: PaymentStatus,
    val created_at: Date,
    val updated_at: Date
)
