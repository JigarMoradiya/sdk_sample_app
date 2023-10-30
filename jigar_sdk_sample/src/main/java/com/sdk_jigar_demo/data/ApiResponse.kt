package com.sdk_jigar_demo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiResponse(
        var status_code : Int = 0,
        var message: String? = null,
        var emotionList : ArrayList<Emotion>? = null
) : Parcelable