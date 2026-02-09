package com.example.lydaandroid.model

enum class FeedType(val value: String) {
    FOLLOWING("following"),
    EXPLORE("explore"),
    HISTORY("history"),
    AUTO_QUEUE("autoQueue"),
    PROFILE_TRACKS("profileTracks"),
    PROFILE_REPOSTS("profileReposts"),
    LIKED_TRACKS("likedTracks"),
    BOUGHT_TRACKS("boughtTracks"),
    PLAYLIST_TRACKS("playlistTracks"),
    ALBUM_TRACKS("albumTracks");

    override fun toString(): String = value
}
