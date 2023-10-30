package com.sdk_jigar_demo.jigar_sdk_sample.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Currency(
        @SerializedName("price")
        val amount: Double,
        val currency: String
) : Parcelable