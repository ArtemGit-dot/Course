package com.example.coursesapplication.presentation.mainmenu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursesapplication.dependecyinjection.DaggerComponent
import com.example.coursesapplication.domain.AddFavoriteListRepository
import com.example.coursesapplication.domain.Course
import com.example.coursesapplication.domain.InstanceRetrofitRepository
import javax.inject.Inject
import kotlin.random.Random

class MainMenuFragmentViewModel : ViewModel() {
    @Inject
    lateinit var instanceRetrofit: InstanceRetrofitRepository

    @Inject
    lateinit var addFavoriteListRepository: AddFavoriteListRepository

    val courseList = MutableLiveData<List<Course>>()
    val courseFavorites = MutableLiveData<List<Course>>()
    val imageNumbers = MutableLiveData<List<Int>>()


    init {
        DaggerComponent.create().inject(this)
    }

    fun loadCourses() {
        instanceRetrofit.createInstanceRetrofit()

        instanceRetrofit.requestApi { courses ->
            courseList.value = courses
        }
    }

    fun generateNumberImage(size: Int): List<Int> {
        var listNumbers = List(size) { Random.nextInt(3) }
        imageNumbers.value = listNumbers
        return listNumbers
    }

    fun addCourseFavorites(course: Course) {
        course.hasLike = true
        val favorites = addFavoriteListRepository
           // if (course.hasLike) {
                val like = favorites.addFavorite(course)
                courseFavorites.value = emptyList()
            courseFavorites.value = like
       // }
       // else {
//                val dislike = favorites.deleteFavorite(course)
//                courseFavorites.value = emptyList()
//                courseFavorites.value = dislike
        //}
    }
}