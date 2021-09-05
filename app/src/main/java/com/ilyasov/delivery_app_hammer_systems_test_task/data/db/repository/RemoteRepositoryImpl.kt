package com.ilyasov.delivery_app_hammer_systems_test_task.data.db.repository

import com.ilyasov.delivery_app_hammer_systems_test_task.data.db.remote.api.APIInterface
import com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity.CocktailsResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val cockTailsAPI: APIInterface
) : RemoteRepository {
    override suspend fun getCocktails(): Response<CocktailsResponse> = cockTailsAPI.getCocktails()
}