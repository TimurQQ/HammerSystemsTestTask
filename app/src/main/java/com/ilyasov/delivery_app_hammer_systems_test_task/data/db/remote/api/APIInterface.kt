package com.ilyasov.delivery_app_hammer_systems_test_task.data.db.remote.api

import com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity.CocktailsResponse
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.BASE_LETTER
import retrofit2.Response

interface APIInterface {
    suspend fun getCocktails(firstLetter: String = BASE_LETTER): Response<CocktailsResponse>
}