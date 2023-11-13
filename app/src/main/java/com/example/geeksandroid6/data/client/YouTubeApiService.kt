package com.example.geeksandroid6.data.client

import com.example.geeksandroid6.data.model.BaseResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {

    @GET("playlists")
    suspend fun getPlaylists(
        @Query("key") apiKey: String,
        @Query("channelId") channelId: String,
        @Query("part") part: String,
        @Query("maxResults") maxResults: Int,

    ): Response<BaseResponse>

    @GET("videos")
    suspend fun getVideos(
        @Query("key") apiKey: String,
        @Query("playlistId") playlistId: String,
        @Query("part") part: String,
        @Query("maxResults") maxResults: Int,

        ): Response<BaseResponse>
}