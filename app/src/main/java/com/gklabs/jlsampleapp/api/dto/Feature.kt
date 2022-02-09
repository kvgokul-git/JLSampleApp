package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Feature(
    val attributes: List<Attribute>
) : Parcelable