package com.fox.hammerfood.data.repository

import com.fox.hammerfood.data.source.FoodService
import com.fox.hammerfood.domain.model.FoodModel
import com.fox.hammerfood.domain.repository.FoodRepository
import com.fox.hammerfood.utils.Constants.APP_ID
import com.fox.hammerfood.utils.Constants.APP_KEY
import com.fox.hammerfood.utils.Constants.QUERY
import com.fox.hammerfood.utils.Constants.TYPE
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val service: FoodService
): FoodRepository {
    override suspend fun getFood(): ArrayList<FoodModel> {
        val foodList = arrayListOf<FoodModel>()
        val result = service.getFood(TYPE, QUERY, APP_ID, APP_KEY, true)
        for(rec in result.recipes) {
            foodList.add(rec.toFoodModel())
        }

        return foodList
    }
}