package com.ilyasov.delivery_app_hammer_systems_test_task

import android.app.Application
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.di.AppComponent
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.di.AppModule
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.di.DaggerAppComponent
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.di.RemoteModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .remoteModule(RemoteModule())
            .build()
    }
}