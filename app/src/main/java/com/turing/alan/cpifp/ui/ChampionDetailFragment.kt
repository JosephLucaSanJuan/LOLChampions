package com.turing.alan.cpifp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.ChampionsRepository
import com.turing.alan.cpifp.data.InMemoryChampionsRepository
import com.turing.alan.cpifp.databinding.FragmentChampionDetailBinding

class ChampionDetailFragment : Fragment() {
    private val repository: ChampionsRepository = InMemoryChampionsRepository.getInstance()
    private val args:ChampionDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentChampionDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChampionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val championID = args.championId
        val champion = repository.getOne(championID)
        binding.championName.text = champion.name
        binding.championTitle.text = champion.title
        binding.championLore.text = champion.lore
        binding.championImage.load(champion.imageUrl)
    }
}