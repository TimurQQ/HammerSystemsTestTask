package com.ilyasov.delivery_app_hammer_systems_test_task.data.db.remote.api

import com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity.CocktailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CockTailsAPI : APIInterface {

    companion object {
        const val GET_COCKTAILS = "api/json/v1/1/search.php"
        const val SET_FIRST_LETTER = "f"
    }

    @GET(GET_COCKTAILS)
    override suspend fun getCocktails(
        @Query(SET_FIRST_LETTER)
        firstLetter: String
    ): Response<CocktailsResponse>
}