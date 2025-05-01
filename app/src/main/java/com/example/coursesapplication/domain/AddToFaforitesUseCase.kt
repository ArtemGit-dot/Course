package com.example.coursesapplication.domain

class AddToFaforitesUseCase (private val addFavoriteListRepository: AddFavoriteListRepository) {
    fun addToFaforites(course: Course){
        addFavoriteListRepository.addFavorite(course)
    }
}