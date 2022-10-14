package com.fox.hammerfood.data.model

import com.google.gson.annotations.SerializedName

data class RootFoodObject(
    @SerializedName("hits") val recipes: List<HitModel>
)
