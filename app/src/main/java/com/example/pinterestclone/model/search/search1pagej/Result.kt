package com.example.pinterestclone.model.search.search1pagej

data class Result(
    val cover_photo: CoverPhoto,
    val curated: Boolean,
    val description: String,
    val featured: Boolean,
    val id: String,
    val last_collected_at: String,
    val links: LinksXX,
    val preview_photos:PreviewPhoto,
    val `private`: Boolean,
    val published_at: String,
    val share_key: String,
    val tags: List<Tag>,
    val title: String,
    val total_photos: Int,
    val updated_at: String,
    val user: UserXX
)