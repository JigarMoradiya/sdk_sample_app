package com.sdk_jigar_demo.jigar_sdk_sample

import android.content.Context


class ConnectedMindSDK {
    companion object{
        var context_: Context? = null
    }
    val instance: Context?
        get() { return context_ }
    fun initialize(context : Context) {
        context_ = context
    }
}