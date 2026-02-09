package com.example.lydaandroid.model

import java.math.BigInteger
import java.util.Date

data class TrackLike(
    val track_id: BigInteger,
    val user_id: BigInteger,
    val created_at: String,
    val updated_at: String,
    val user: User? = null,
)
