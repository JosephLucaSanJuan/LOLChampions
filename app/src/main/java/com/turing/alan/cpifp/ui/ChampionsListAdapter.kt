package com.turing.alan.cpifp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.data.Champion
import com.turing.alan.cpifp.databinding.ChampionListBinding

class ChampionsListAdapter():ListAdapter<Champion, ChampionsListAdapter.ChampionViewHolder>(ChampionDiffCallback) {
    class ChampionViewHolder(private val binding: ChampionListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(champion:Champion) {
            binding.championName.text = champion.name
            binding.championTitle.text = champion.title
            binding.championLore.text = champion.lore
        }
    }

    object ChampionDiffCallback: DiffUtil.ItemCallback<Champion>(){
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion) = oldItem.name == newItem.name &&
                oldItem.title == newItem.title &&
                oldItem.lore == newItem.lore
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val binding:ChampionListBinding = ChampionListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChampionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}