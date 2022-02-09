package com.gklabs.jlsampleapp.utils.log

interface RemoteLogger {

    fun log(message: String)

    fun logRemoteException(throwable: Throwable)
}