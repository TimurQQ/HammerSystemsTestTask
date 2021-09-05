package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.GsonBuilder
import com.ilyasov.delivery_app_hammer_systems_test_task.data.db.remote.api.APIInterface
import com.ilyasov.delivery_app_hammer_systems_test_task.data.db.remote.api.CockTailsAPI
import com.ilyasov.delivery_app_hammer_systems_test_task.data.db.repository.RemoteRepository
import com.ilyasov.delivery_app_hammer_systems_test_task.data.db.repository.RemoteRepositoryImpl
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.API_HOST
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.API_KEY
import com.ilyasov.delivery_app_hammer_systems_test_task.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {

        val client = OkHttpClient.Builder().apply {
            addInterceptor(Interceptor { chain ->
                val request: Request =
                    chain.request().newBuilder()
                        .addHeader("x-rapidapi-host", API_HOST)
                        .addHeader(
                            "x-rapidapi-key",
                            API_KEY
                        ).build()
                chain.proceed(request)
            })
        }.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                )
            )
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIInterface(retrofit: Retrofit): APIInterface =
        retrofit.create(CockTailsAPI::class.java)

    @Singleton
    @Provides
    fun providesRemoteRepository(service: APIInterface): RemoteRepository =
        RemoteRepositoryImpl(service)

    @Singleton
    @Provides
    fun provideConnectivityManager(application: Application): ConnectivityManager =
        application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}
