package com.gklabs.jlsampleapp.di

import com.gklabs.jlsampleapp.config.ConfigProviderImpl
import com.gklabs.jlsampleapp.config.ConfigProvider
import com.gklabs.jlsampleapp.utils.log.CrashlyticsLogger
import com.gklabs.jlsampleapp.utils.log.RemoteLogger
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Reusable
    fun provideConfigProvider(): ConfigProvider = ConfigProviderImpl

    @Provides
    @Reusable
    fun provideRemoteLogger(): RemoteLogger = CrashlyticsLogger
}