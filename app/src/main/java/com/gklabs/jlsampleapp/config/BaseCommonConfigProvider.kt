package com.gklabs.jlsampleapp.config

import com.gklabs.jlsampleapp.BuildConfig


abstract class BaseCommonConfigProvider : ConfigProvider {

    override val isDebug = BuildConfig.DEBUG
}