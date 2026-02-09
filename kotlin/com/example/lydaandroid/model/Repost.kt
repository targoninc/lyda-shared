package com.example.lydaandroid.model

import java.math.BigInteger

data class Repost(
    val track_id: BigInteger? = null,
    val user_id: BigInteger? = null,
    val created_at: String = "",
    val user: User? = null,
)
