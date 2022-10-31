package com.example.quizapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * How we construct the dependencies so that dagger can inject the classes.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
}