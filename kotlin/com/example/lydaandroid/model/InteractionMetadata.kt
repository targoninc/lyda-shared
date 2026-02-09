package com.example.lydaandroid.model

data class InteractionMetadata<T>(
    val count: Int? = null,
    val interacted: Boolean? = null,
    val list: List<T>? = null
)
