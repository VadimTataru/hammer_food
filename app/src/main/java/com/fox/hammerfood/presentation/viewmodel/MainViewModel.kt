package com.fox.hammerfood.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fox.hammerfood.domain.interactor.FoodInteractor
import com.fox.hammerfood.domain.model.FoodModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: FoodInteractor
): ViewModel() {

    private var foodList = MutableLiveData<MutableList<FoodModel>>()

    fun getFoodList(): MutableLiveData<MutableList<FoodModel>> {
        return foodList
    }

    fun getFood() {
        viewModelScope.launch {
            foodList.value = interactor.getFood().toMutableList()
        }
    }

}