package com.example.testApp.data.repositories.remoteRepository

import com.example.testApp.data.RecipesResponseModel
import com.example.testApp.utils.API_KEY
import com.example.testApp.utils.DEFAULT_DATA_TYPE
import com.example.testApp.utils.ENDPOIND_APP_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteRepository {
    @GET("v2")
    suspend fun getRecipes(
        @Query("q") query:String,
        @Query("type") type:String = DEFAULT_DATA_TYPE,
        @Query("app_id") endPointAppId:String = ENDPOIND_APP_ID,
        @Query("app_key") apiKey:String = API_KEY,
        @Query("random") random:Boolean = false,
    ) : Response<RecipesResponseModel>
}