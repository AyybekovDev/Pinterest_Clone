package com.example.pinterestclone.model.search

data class CoverPhotoXX(
    val alt_description: String,
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val premium: Boolean,
    val promoted_at: String,
    val sponsorship: Any,
    val topic_submissions: TopicSubmissionsXX,
    val updated_at: String,
    val user: UserXXX,
    val width: Int
)