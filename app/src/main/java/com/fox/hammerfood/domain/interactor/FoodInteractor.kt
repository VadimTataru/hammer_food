package com.fox.hammerfood.domain.interactor

import com.fox.hammerfood.domain.model.FoodModel
import com.fox.hammerfood.domain.repository.FoodRepository
import javax.inject.Inject

class FoodInteractor @Inject constructor(
    private val repository: FoodRepository
) {
    suspend fun getFood(): ArrayList<FoodModel> {
        return repository.getFood()
    }
}