package com.example.lydaandroid.model

import com.beust.klaxon.Json

enum class SubscriptionStatus(val value: Int) {
    @Json(index = 0)
    created(0),

    @Json(index = 1)
    pending(1),

    @Json(index = 2)
    active(2),

    @Json(index = 3)
    cancelled(3)
}
