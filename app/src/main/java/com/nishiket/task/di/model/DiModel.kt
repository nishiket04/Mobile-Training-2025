package com.nishiket.task.di.model

import com.nishiket.task.di.Person
import com.nishiket.task.di.repository.repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModel {

    @Provides
    @Singleton
    fun providesRepo(): repository {
        return repository()
    }

    @Provides
    @Singleton
    fun providesClass(): Person{
        return Person("nishiket","7405105330",20)
    }
}