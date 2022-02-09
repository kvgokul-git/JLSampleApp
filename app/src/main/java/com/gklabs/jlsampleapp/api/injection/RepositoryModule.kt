package com.gklabs.jlsampleapp.api.injection

import com.gklabs.jlsampleapp.api.repositories.ProductRepository
import com.gklabs.jlsampleapp.api.repositories.ProductRepositoryImpl
import com.gklabs.jlsampleapp.network.NetworkApiCallDelegate
import com.gklabs.jlsampleapp.network.NetworkApiCallDelegateImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindNetworkApiExecutor(
        networkApiExecutorImpl: NetworkApiCallDelegateImpl
    ): NetworkApiCallDelegate

    @Binds
    @Singleton
    abstract fun bindProductsRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}