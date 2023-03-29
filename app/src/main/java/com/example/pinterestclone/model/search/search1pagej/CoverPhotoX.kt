package com.example.pinterestclone.model.search.search1pagej

import com.example.pinterestclone.model.search.LinksXXX

data class CoverPhotoX(
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
    val links: LinksXXX,
    val premium: Boolean,
    val promoted_at: String,
    val sponsorship: Any,
    val topic_submissions: TopicSubmissionsX,
    val updated_at: String,
    val urls: Urls,
    val user: UserX,
    val width: Int
)