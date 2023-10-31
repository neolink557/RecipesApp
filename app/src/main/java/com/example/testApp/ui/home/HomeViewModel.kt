package com.example.testApp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testApp.data.RecipesResponseModel
import com.example.testApp.domain.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase) :
    ViewModel() {


    private var _recipes = MutableLiveData<RecipesResponseModel>()
    val recipes: LiveData<RecipesResponseModel> = _recipes

    fun getRecipes(query: String) {
        viewModelScope.launch {
            val response = getRecipesUseCase.invoke(query)
            if (response.isSuccessful){
                _recipes.postValue(response.body())
            }
        }
    }
}


