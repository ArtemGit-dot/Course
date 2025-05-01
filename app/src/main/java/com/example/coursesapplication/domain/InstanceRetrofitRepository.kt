package com.example.coursesapplication.domain

import javax.inject.Inject


interface InstanceRetrofitRepository{

    fun createInstanceRetrofit ()

    fun requestApi(callback: (List<Course>) -> Unit)
}