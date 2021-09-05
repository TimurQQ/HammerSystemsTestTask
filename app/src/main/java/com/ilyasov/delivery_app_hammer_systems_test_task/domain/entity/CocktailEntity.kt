package com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CocktailEntity(
    @SerializedName("dateModified")
    @Expose
    val dateModified: String,
    @SerializedName("idDrink")
    @Expose
    val id: String,
    @SerializedName("strAlcoholic")
    @Expose
    val strAlcoholic: String,
    @SerializedName("strCategory")
    @Expose
    val category: String,
    @SerializedName("strDrink")
    @Expose
    val name: String,
    @SerializedName("strDrinkThumb")
    @Expose
    val imgURL: String,
    @SerializedName("strGlass")
    @Expose
    val glassType: String,
    @SerializedName("strInstructions")
    @Expose
    val instruction: String,
    @SerializedName("strTags")
    @Expose
    val tags: String,
)