package com.gklabs.jlsampleapp.api.injection

import com.gklabs.jlsampleapp.api.ProductsApi
import com.gklabs.jlsampleapp.config.ConfigProvider
import com.gklabs.jlsampleapp.config.MoshiAdapterConfig.getMoshiConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideProductsApi(
        configProvider: ConfigProvider,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): ProductsApi {
        return Retrofit.Builder()
            .baseUrl(configProvider.apiBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(ProductsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(configProvider: ConfigProvider) =
        HttpLoggingInterceptor().apply { level = if (configProvider.isDebug) BODY else NONE }

    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): Converter.Factory =
        MoshiConverterFactory.create(moshi).asLenient()

    @Provides
    @Singleton
    fun provideMoshiConfig(): Moshi = getMoshiConfig()
}