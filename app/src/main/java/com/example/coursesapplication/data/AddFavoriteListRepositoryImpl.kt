package com.example.coursesapplication.data

import com.example.coursesapplication.domain.AddFavoriteListRepository
import com.example.coursesapplication.domain.Course
import javax.inject.Inject

class AddFavoriteListRepositoryImpl @Inject constructor() : AddFavoriteListRepository {

    val favoriteList = mutableListOf<Course>()

    override fun addFavorite(course: Course) : List<Course> {
        favoriteList.add(course)
        return favoriteList.toList()
    }

//    override fun deleteFavorite(course: Course): List<Course> {
//        favoriteList.remove(course)
//        return favoriteList
//    }
}