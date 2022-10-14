package com.fox.hammerfood.di

import com.fox.hammerfood.domain.interactor.FoodInteractor
import com.fox.hammerfood.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class InteractorModule {
    @Provides
    fun provideInteractor(repository: FoodRepository): FoodInteractor {
        return FoodInteractor(repository)
    }
}