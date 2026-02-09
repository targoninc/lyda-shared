package com.example.lydaandroid.model

import java.util.Date

data class Subscription(
    val id: Int,
    val user_id: Int,
    val subscription_id: Int,
    val status: SubscriptionStatus,
    val created_at: Date,
    val updated_at: Date,
    val cancelled_at: Date? = null,
    val previous_subscription: Int? = null,
    val external_subscription_id: String? = null,
    val external_order_id: String? = null,
    val gifted_by_user_id: Int? = null,
    val next_billing_time: Date? = null,
    val outstanding_balance: String? = null,
    val currency_code: String? = null
)
