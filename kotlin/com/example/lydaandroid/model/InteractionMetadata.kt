package com.example.lydaandroid.model

data class CommentMetadata(
    val count: Int? = null,
    val interacted: Boolean? = null,
    val list: List<Comment>? = null
)

data class TrackLikeMetadata(
    val count: Int? = null,
    val interacted: Boolean? = null,
    val list: List<TrackLike>? = null
)

data class RepostMetadata(
    val count: Int? = null,
    val interacted: Boolean? = null,
    val list: List<Repost>? = null
)

data class GenericMetadata(
    val count: Int? = null,
    val interacted: Boolean? = null,
    val list: List<Any>? = null
)
