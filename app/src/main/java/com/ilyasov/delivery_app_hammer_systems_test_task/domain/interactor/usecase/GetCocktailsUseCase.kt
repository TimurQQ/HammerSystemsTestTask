package com.ilyasov.delivery_app_hammer_systems_test_task.domain.interactor.usecase

import com.ilyasov.delivery_app_hammer_systems_test_task.data.db.repository.RemoteRepository
import com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity.CocktailsResponse
import retrofit2.Response
import javax.inject.Inject

class GetCocktailsUseCase @Inject constructor(
    private val repo: RemoteRepository
) {
    suspend fun execute(firstLetter: String = "a"): Response<CocktailsResponse> =
        repo.getCocktails(firstLetter)
}