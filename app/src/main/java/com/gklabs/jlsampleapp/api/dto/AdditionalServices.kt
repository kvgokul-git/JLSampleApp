package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdditionalServices(
    val includedServices: List<String>
) : Parcelable