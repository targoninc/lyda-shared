package com.example.lydaandroid.model

import java.util.Date

data class TrackCollaborator(
    val track_id: Int,
    val user_id: Int,
    val type: Int,
    val approved: Boolean,
    val denied: Boolean,
    val created_at: String,
    val updated_at: String,
    val collab_type: CollaboratorType? = null,
    val track: Track? = null,
    val user: User? = null
)
