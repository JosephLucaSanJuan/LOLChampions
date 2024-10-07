package com.turing.alan.cpifp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.turing.alan.cpifp.data.Champion
import com.turing.alan.cpifp.databinding.ChampionListBinding

class ChampionsListAdapter():ListAdapter<Champion, ChampionsListAdapter.ChampionsViewHolder>(ChampionDiffCallback) {
    class ChampionsViewHolder(private val binding: ChampionListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(champion:Champion){
            binding.championName.text = champion.name
            binding.championTitle.text = champion.title
            binding.championLore.text = champion.lore
            binding.championImage.load(champion.imageUrl)
        }
    }

    object ChampionDiffCallback:DiffUtil.ItemCallback<Champion>() {
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion) =
            oldItem.name == newItem.name &&
                    oldItem.title == newItem.title &&
                    oldItem.lore == newItem.lore
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionsViewHolder {
        val binding:ChampionListBinding = ChampionListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChampionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChampionsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}