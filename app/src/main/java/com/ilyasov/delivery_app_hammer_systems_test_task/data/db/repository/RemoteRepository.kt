package com.ilyasov.delivery_app_hammer_systems_test_task.data.db.repository

import com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity.CocktailsResponse
import retrofit2.Response

interface RemoteRepository {
    suspend fun getCocktails(): Response<CocktailsResponse>
}