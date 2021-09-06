package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilyasov.delivery_app_hammer_systems_test_task.ViewModelKey
import com.ilyasov.delivery_app_hammer_systems_test_task.ViewModelProviderFactory
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.viewmodels.GetCocktailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GetCocktailsViewModel::class)
    abstract fun bindGetGifViewModel(viewModel: GetCocktailsViewModel): ViewModel
}