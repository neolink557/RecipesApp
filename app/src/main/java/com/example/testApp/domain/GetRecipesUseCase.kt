package com.example.testApp.domain

import com.example.testApp.data.RecipesResponseModel
import com.example.testApp.data.repositories.remoteRepository.RemoteRepository
import retrofit2.Response
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val repository: RemoteRepository) {
    suspend operator fun invoke(query: String): Response<RecipesResponseModel> =
        repository.getRecipes(query)
}