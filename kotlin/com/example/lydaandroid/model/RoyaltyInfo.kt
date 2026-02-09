package com.example.lydaandroid.model

data class RoyaltyInfo(
    val personal: PersonalRoyaltyInfo,
    val global: GlobalRoyaltyInfo
)

data class PersonalRoyaltyInfo(
    val trackRoyaltyValues: BoxPlotValues,
    val meanTrackRoyalty: Double,
    val paidTotal: Double,
    val available: Double,
    val totalRoyalties: Double,
    val paypalMail: String? = null
)

data class GlobalRoyaltyInfo(
    val meanTrackRoyalty: Double,
    val paidTotal: Double,
    val totalRoyalties: Double,
    val trackRoyaltyValues: BoxPlotValues,
    val counts: GlobalCounts
)

data class GlobalCounts(
    val users: Int,
    val tracks: Int,
    val albums: Int,
    val playlists: Int
)
