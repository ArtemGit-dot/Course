package com.example.coursesapplication.data

import android.util.Log
import com.example.coursesapplication.domain.Course
import com.example.coursesapplication.domain.CourseResponse
import com.example.coursesapplication.domain.InstanceRetrofitRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class InstanceRetrofitRepositoryImpl @Inject constructor(): InstanceRetrofitRepository {
    val baseurl = "https://drive.usercontent.google.com/"
    lateinit var apiService : ApiService

    override fun createInstanceRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    override fun requestApi(callback: (List<Course>) -> Unit) {

        apiService.getCourses().enqueue(object : Callback<CourseResponse> {
            override fun onResponse(
                call: Call<CourseResponse>?,
                response: Response<CourseResponse>?
            ) {
                val courseList = response?.body()?.courses.orEmpty()
                callback(courseList)

            }

            override fun onFailure(call: Call<CourseResponse>?, t: Throwable?) {
                Log.d("MyL", "Oshibka2: ${t?.message}")
            }
        })
    }

}