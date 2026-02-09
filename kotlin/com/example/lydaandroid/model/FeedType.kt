package com.example.lydaandroid.model

import com.beust.klaxon.Json

enum class FeedType(val value: String) {
    @Json(name = "following")
    FOLLOWING("following"),

    @Json(name = "explore")
    EXPLORE("explore"),

    @Json(name = "history")
    HISTORY("history"),

    @Json(name = "autoQueue")
    AUTO_QUEUE("autoQueue"),

    @Json(name = "profileTracks")
    PROFILE_TRACKS("profileTracks"),

    @Json(name = "profileReposts")
    PROFILE_REPOSTS("profileReposts"),

    @Json(name = "likedTracks")
    LIKED_TRACKS("likedTracks"),

    @Json(name = "boughtTracks")
    BOUGHT_TRACKS("boughtTracks"),

    @Json(name = "playlistTracks")
    PLAYLIST_TRACKS("playlistTracks"),

    @Json(name = "albumTracks")
    ALBUM_TRACKS("albumTracks");

    override fun toString(): String = value
}
