package com.fox.hammerfood.data.model

import com.google.gson.annotations.SerializedName

data class RecipeModel(
    @SerializedName("label") val title: String,
    @SerializedName("image") val img_url: String,
    @SerializedName("ingredientLines") val description: List<String>
)