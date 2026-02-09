package com.example.lydaandroid.model

import java.math.BigInteger
import java.util.Date

data class Repost(
    val track_id: BigInteger,
    val user_id: BigInteger,
    val created_at: Date,
    val user: User? = null,
)
