package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Price(
    val currency: String,
    val now: String,
    val then1: String,
    val then2: String,
    val uom: String,
    val was: String
) : Parcelable