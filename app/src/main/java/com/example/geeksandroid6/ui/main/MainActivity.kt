package com.example.geeksandroid6.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geeksandroid6.databinding.ActivityMainBinding
import com.example.geeksandroid6.ui.adapter.PlaylistsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { PlaylistsAdapter(this::onClick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getPlaylist()

        binding.rv.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

        viewModel.getPlaylist().observe(this) {
            adapter.submitList(it)
        }
    }

    private fun onClick(playlistId: String){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("playlistId", playlistId)
        startActivity(intent)
    }
}