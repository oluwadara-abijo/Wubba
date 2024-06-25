package com.dara.wubba.di

import android.app.Application
import android.content.Context
import com.dara.core.network.utils.ErrorHandler
import com.dara.core.network.utils.ErrorHandlerImpl
import com.dara.core.network.utils.StringProvider
import com.dara.core.network.utils.StringProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext

    @Provides
    fun providesResourceProvider(resourceProvider: StringProviderImpl): StringProvider =
        resourceProvider

    @Provides
    fun provideErrorHandler(errorHandler: ErrorHandlerImpl): ErrorHandler = errorHandler

    @Provides
    fun provideCoroutineScope(): CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Default)
}
