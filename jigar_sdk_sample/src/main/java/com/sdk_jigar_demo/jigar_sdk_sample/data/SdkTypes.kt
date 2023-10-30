package com.sdk_jigar_demo.jigar_sdk_sample.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SdkTypes(
    val title: String,
    val childs: ArrayList<SdkChild>,
) : Parcelable

@Parcelize
data class SdkChild(
    val id: String,
    val title: String,
) : Parcelable