package com.example.geeksandroid6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.geeksandroid6.data.model.Item
import com.example.geeksandroid6.databinding.ItemPlaylistBinding

class PlaylistsAdapter(val onClick:(playlistId: String)->Unit): ListAdapter<Item, PlaylistsAdapter.PlaylistViewHolder>(
    PlaylistItemDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder = PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick
        )

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    class PlaylistViewHolder(private val binding: ItemPlaylistBinding, val onClick:(playlistId: String)->Unit): ViewHolder(binding.root) {
        fun onBind(item: Item?) {
            binding.tvTitle.text = item?.snippet?.title
            Glide.with(itemView.context)
                .load(item?.snippet?.thumbnails?.medium?.url)
                .into(binding.ivPlaylists)
            itemView.setOnClickListener {
                onClick(item?.id.toString())
            }
        }
    }

    class PlaylistItemDiffUtil: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem

    }
}