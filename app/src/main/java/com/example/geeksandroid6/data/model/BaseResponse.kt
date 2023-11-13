package com.example.geeksandroid6.data.model

import com.google.gson.annotations.SerializedName


data class BaseResponse(
    @SerializedName("etag")
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)