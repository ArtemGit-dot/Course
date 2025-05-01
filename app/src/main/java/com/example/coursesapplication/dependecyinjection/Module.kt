package com.example.coursesapplication.dependecyinjection

import com.example.coursesapplication.data.AddFavoriteListRepositoryImpl
import com.example.coursesapplication.data.InstanceRetrofitRepositoryImpl
import com.example.coursesapplication.domain.AddFavoriteListRepository
import com.example.coursesapplication.domain.InstanceRetrofitRepository
import dagger.Binds
import dagger.Module

@Module
interface Module {

    @Binds
    fun provideRetrofit (impl: InstanceRetrofitRepositoryImpl) : InstanceRetrofitRepository

    @Binds
    fun provideAddFavoriteListRepository (impl: AddFavoriteListRepositoryImpl) : AddFavoriteListRepository
}