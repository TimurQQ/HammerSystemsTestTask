package com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CocktailsResponse(
    @SerializedName("drinks")
    @Expose
    val drinks: List<CocktailEntity>
)