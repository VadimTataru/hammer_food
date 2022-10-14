package com.fox.hammerfood.di

import com.fox.hammerfood.data.repository.FoodRepositoryImpl
import com.fox.hammerfood.data.source.FoodService
import com.fox.hammerfood.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class RepositoryModule {
    @Provides
    fun provideFoodRepository(service: FoodService): FoodRepository {
        return FoodRepositoryImpl(service)
    }
}