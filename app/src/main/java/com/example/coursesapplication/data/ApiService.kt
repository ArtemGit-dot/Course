package com.example.coursesapplication.data

import com.example.coursesapplication.domain.CourseResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    fun getCourses(): Call<CourseResponse>

      /*  fun request(apiService: ApiService){
            apiService.getCourses().enqueue(object : Callback<List<Course>>{
                override fun onResponse(
                    call: Call<List<Course>>?,
                    response: Response<List<Course>>?
                ) {
                    Log.d("Retro", "Response: ${response?.body()}")

                }

                override fun onFailure(call: Call<List<Course>>?, t: Throwable?) {
                    Log.d("MyL", "Oshibka2: ${t?.message}")
                }

            }
        }*/
    }
