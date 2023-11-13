package com.example.geeksandroid6.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geeksandroid6.R
import com.example.geeksandroid6.databinding.ActivitySecondBinding
import com.example.geeksandroid6.ui.adapter.VideosAdapter

class SecondActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivitySecondBinding
    private val adapter by lazy { VideosAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playlistId : String = intent.getBundleExtra("playlistId").toString()
        viewModel.getVideos(playlistId)

        binding.rv.apply {
            adapter = this@SecondActivity.adapter
            layoutManager = LinearLayoutManager(
                this@SecondActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

        viewModel.getVideos(playlistId).observe(this) {
//            adapter.submitList(it)
        }
    }
}