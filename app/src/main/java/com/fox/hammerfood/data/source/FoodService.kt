package com.fox.hammerfood.data.source

import com.fox.hammerfood.data.model.RootFoodObject
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {

    @GET("/api/recipes/v2")
    suspend fun getFood(
        @Query("type") type: String,
        @Query("q") query: String,
        @Query("app_id") app_id: String,
        @Query("app_key") app_key: String,
        @Query("random") random: Boolean
    ): RootFoodObject
}