package com.gklabs.jlsampleapp.config

import com.gklabs.jlsampleapp.BuildConfig

object ConfigProviderImpl : BaseCommonConfigProvider() {

    override val apiBaseUrl =
        BuildConfig.API_BASE_URL
}