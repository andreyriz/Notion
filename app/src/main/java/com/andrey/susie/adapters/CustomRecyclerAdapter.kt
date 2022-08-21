package com.andrey.susie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.andrey.susie.R
import com.andrey.susie.databinding.MusicCompositionItemBinding
import com.andrey.susie.data.Music
import com.bumptech.glide.Glide
import timber.log.Timber

class HomeRecyclerViewAdapter(private val musics: List<Music>, private val onItemClicked: (Music) -> Unit) :
    PagingDataAdapter<Music, HomeRecyclerViewAdapter.HomeViewHolder>(object : DiffUtil.ItemCallback<Music>() {
        override fun areItemsTheSame(oldItem: Music, newItem: Music): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Music, newItem: Music): Boolean =
            oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            MusicCompositionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        (holder as? HomeViewHolder)?.bind(holder, musics[position], position)
    }

    override fun getItemCount() = musics.size

    inner class HomeViewHolder(private val binding: MusicCompositionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val imgView: ImageView = itemView.findViewById(R.id.imgView)
        private val title: TextView = itemView.findViewById(R.id.title)
        private var iitem:Music? = null

        fun bind(holder:HomeViewHolder, item:Music, position:Int){
            iitem = item
            title.text = item.music_name
            Glide.with(imgView).load(item.music_img).into(imgView)

            holder.binding.content.setOnClickListener { onItemClicked.invoke(item) }
        }
    }
}