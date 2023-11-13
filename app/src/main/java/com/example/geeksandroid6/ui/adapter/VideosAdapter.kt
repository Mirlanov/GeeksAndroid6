package com.example.geeksandroid6.ui.adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geeksandroid6.databinding.ItemVideoBinding

class VideosAdapter: ListAdapter<Item, VideosAdapter.VideoViewHolder>(
    VideoItemDiffUtil()
) {
    class VideoViewHolder(private val binding: ItemVideoBinding): ViewHolder(binding.root) {
        fun onBind(item: Item?) {
            binding.tvTitle.text = "video"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder = VideoViewHolder(
        ItemVideoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class VideoItemDiffUtil: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem //toDo: add id's when response is ready

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
    }
}