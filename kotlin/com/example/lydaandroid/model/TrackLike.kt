package com.example.lydaandroid.model

import java.math.BigInteger

data class TrackLike(
    val track_id: BigInteger? = null,
    val user_id: BigInteger? = null,
    val created_at: String = "",
    val updated_at: String = "",
    val user: User? = null,
)
