package com.fox.hammerfood.domain.repository

import com.fox.hammerfood.domain.model.FoodModel

interface FoodRepository {
    suspend fun getFood(): ArrayList<FoodModel>
}