package com.example.geeksandroid6.data.model

data class SnippetX(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val localized: Localized,
    val publishedAt: String,
    val thumbnails: ThumbnailsX,
    val title: String
)