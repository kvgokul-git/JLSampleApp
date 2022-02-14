package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Price(
    @Json(name = "currency") val currency: String,
    @Json(name = "now") val now: String,
    @Json(name = "then1") val then1: String,
    @Json(name = "then2") val then2: String,
    @Json(name = "uom") val uom: String,
    @Json(name = "was") val was: String
) : Parcelable