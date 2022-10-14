package com.fox.hammerfood.data.model

import com.fox.hammerfood.domain.model.FoodModel
import com.google.gson.annotations.SerializedName

data class HitModel(
    @SerializedName("recipe") val item: RecipeModel
) {
    fun toFoodModel(): FoodModel {
        var description = ""
        for (line in item.description) {
            description += line + "\n"
        }
        return FoodModel(item.title, description, item.img_url)
    }
}