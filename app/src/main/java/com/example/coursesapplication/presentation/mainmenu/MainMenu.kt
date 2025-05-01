package com.example.coursesapplication.presentation.mainmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.coursesapplication.R
import com.example.coursesapplication.databinding.ActivityMainMenuBinding

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        binding.bNav.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.home -> {
                    navController.navigate(R.id.navHomeMenuFragment)
                }
                R.id.favorites -> {
                    navController.navigate(R.id.navFavoritesFragment)
                }
            }
            true
        }
    }
}