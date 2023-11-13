package com.example.geeksandroid6.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geeksandroid6.data.model.Item
import com.example.geeksandroid6.data.repo.YouTubeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: YouTubeRepo
): ViewModel() {

//    private val _playlists = MutableLiveData<List<Item>>()
//    val playlists : LiveData<List<Item>> = _playlists

    fun getPlaylist(): LiveData<List<Item>> {
        return repo.getPlaylists()
    }

    fun getVideos(playlistId: String): LiveData<List<Item>> {
        return repo.getVideos(playlistId)
    }
}