package com.gklabs.jlsampleapp.config

interface ConfigProvider {

    val isDebug: Boolean

    val apiBaseUrl: String

}