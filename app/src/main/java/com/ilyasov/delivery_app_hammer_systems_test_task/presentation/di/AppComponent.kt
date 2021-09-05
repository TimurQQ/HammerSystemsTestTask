package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.di

import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments.base.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RemoteModule::class])
interface AppComponent {
    fun inject(baseFragment: BaseFragment)
}