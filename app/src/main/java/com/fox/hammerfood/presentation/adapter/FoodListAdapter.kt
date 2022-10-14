package com.fox.hammerfood.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.hammerfood.R
import com.fox.hammerfood.data.model.HitModel
import com.fox.hammerfood.databinding.FoodItemBinding
import com.fox.hammerfood.domain.model.FoodModel

class FoodListAdapter: RecyclerView.Adapter<FoodListAdapter.FoodListHolder>() {
    private var foodList = mutableListOf<FoodModel>()

    class FoodListHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = FoodItemBinding.bind(item)

        fun bind(food: FoodModel) {
            binding.foodTitle.text = food.title
            binding.foodDescription.text = food.description

            Glide.with(binding.foodIv)
                .load(food.imageUrl)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.foodIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodListHolder(view)
    }

    override fun onBindViewHolder(holder: FoodListHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(list: MutableList<FoodModel>) {
        foodList = list
        notifyDataSetChanged()
    }
}