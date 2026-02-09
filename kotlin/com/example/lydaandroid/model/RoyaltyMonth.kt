package com.example.lydaandroid.model

data class RoyaltyMonth(
    val month: Int,
    val year: Int,
    val hasEarnings: Boolean,
    val streamingEarnings: Double,
    val saleEarnings: Double,
    val artistRoyalties: Double,
    val trackRoyalties: Double,
    val calculated: Boolean,
    val approved: Boolean
)
