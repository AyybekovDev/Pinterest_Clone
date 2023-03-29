package com.example.pinterestclone.searchPageModel

data class Search(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)