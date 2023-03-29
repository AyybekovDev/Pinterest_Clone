package com.example.pinterestclone.model.search

data class RelatedCollections(
    val results: List<Result>,
    val total: Int,
    val type: String
)