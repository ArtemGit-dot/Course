package com.example.coursesapplication.presentation.mainactivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.coursesapplication.R
import com.example.coursesapplication.databinding.FragmentOnboardingBinding
import com.example.coursesapplication.presentation.mainmenu.MainMenu

class Onboarding : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController= findNavController()

        binding.buttonContinue.setOnClickListener {
            navController.navigate(R.id.login)
        }
    }
}