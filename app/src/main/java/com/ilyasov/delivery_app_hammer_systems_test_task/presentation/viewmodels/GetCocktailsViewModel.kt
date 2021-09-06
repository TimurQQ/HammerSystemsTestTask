package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyasov.delivery_app_hammer_systems_test_task.domain.interactor.usecase.GetCocktailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetCocktailsViewModel @Inject constructor(
    private val getCocktailsUseCase: GetCocktailsUseCase
) : ViewModel() {

    fun getCocktails() = viewModelScope.launch(Dispatchers.Main) {

    }
}