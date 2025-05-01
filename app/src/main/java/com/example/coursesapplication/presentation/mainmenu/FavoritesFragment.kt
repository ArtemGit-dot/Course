package com.example.coursesapplication.presentation.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.coursesapplication.R
import com.example.coursesapplication.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    lateinit var binding : FragmentFavoritesBinding
    lateinit var viewModel: MainMenuFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterFavorites()
        val recyclerView = binding.recyclerViewFavorites
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(requireActivity())[MainMenuFragmentViewModel::class.java]

        viewModel.courseFavorites.observe(viewLifecycleOwner){
            adapter.courseFavorites.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}