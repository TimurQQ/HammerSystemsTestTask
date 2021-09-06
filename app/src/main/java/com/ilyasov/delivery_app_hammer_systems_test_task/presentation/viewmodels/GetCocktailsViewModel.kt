package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity.CocktailEntity
import com.ilyasov.delivery_app_hammer_systems_test_task.domain.interactor.usecase.GetCocktailsUseCase
import com.ilyasov.delivery_app_hammer_systems_test_task.domain.interactor.usecase.NetworkConnectionUseCase
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.BASE_LETTER
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.NO_NETWORK_CONNECTION
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.RESPONSE_FAILED
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.START_LOADING
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.STOP_LOADING
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetCocktailsViewModel @Inject constructor(
    private val getCocktailsUseCase: GetCocktailsUseCase,
    val networkConnectionUseCase: NetworkConnectionUseCase
) : ViewModel() {
    val cocktailsListLiveData: MutableLiveData<List<CocktailEntity>> = MutableLiveData()
    val loadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val errorStateLiveData: MutableLiveData<String> = MutableLiveData()

    fun getCocktails(firstLetter: String = BASE_LETTER) = viewModelScope.launch(Dispatchers.Main) {
        if (!isConnected()) {
            errorStateLiveData.postValue(NO_NETWORK_CONNECTION)
            return@launch
        }
        loadingMutableLiveData.postValue(START_LOADING)
        val response = getCocktailsUseCase.execute(firstLetter)
        loadingMutableLiveData.postValue(STOP_LOADING)
        val body = response.body()

        if (!response.isSuccessful || body == null) {
            errorStateLiveData.postValue(RESPONSE_FAILED)
            return@launch
        } else {
            cocktailsListLiveData.postValue(body.drinks)
        }
    }

    private fun isConnected(): Boolean = networkConnectionUseCase.isInternetAvailable()
}