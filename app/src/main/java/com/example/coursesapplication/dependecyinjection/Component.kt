package com.example.coursesapplication.dependecyinjection

import com.example.coursesapplication.presentation.mainmenu.MainMenuFragmentViewModel
import dagger.Component

@Component (modules = [Module::class])
interface Component {

    fun inject(mainMenuFragmentViewModel: MainMenuFragmentViewModel)
}