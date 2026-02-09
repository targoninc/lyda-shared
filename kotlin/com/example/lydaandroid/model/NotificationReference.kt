package com.example.lydaandroid.model

data class NotificationReference(
    val type: NotificationReferenceType,
    val id: Int,
    val `object`: Any? = null
)
