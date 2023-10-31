package com.example.testApp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testApp.data.RecipesResponseModel
import com.example.testApp.domain.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase) :
    ViewModel() {


    private var _recipes = MutableStateFlow<RecipesResponseModel?>(null)
    val recipes: StateFlow<RecipesResponseModel?> = _recipes

    init {
        getRecipes("\"chicken\"")
    }
    private fun getRecipes(query: String) {
        viewModelScope.launch {
            val response = getRecipesUseCase.invoke(query)
            Log.d("test", response.toString())
            if (response.isSuccessful){
                _recipes.value = response.body()
            }
        }
    }
}


