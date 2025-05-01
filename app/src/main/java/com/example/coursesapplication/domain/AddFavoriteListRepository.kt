package com.example.coursesapplication.domain

interface AddFavoriteListRepository {
    fun addFavorite(course: Course) : List<Course>

   // fun deleteFavorite(course: Course) : List<Course>
}