package com.sdk_jigar_demo.jigar_sdk_sample.data

import com.sdk_jigar_demo.jigar_sdk_sample.utils.Constants


class Error(
    var message: String? = Constants.API_ERROR, var userMessage: String? = null,
    var errorType: String? = Constants.API_ERROR_TYPE, var error: Boolean = false,
    var sessions: ArrayList<ErrorSession>? = null, val allowed_domains : List<String>? = null
) {

    override fun toString(): String {
        return "Error(message=$message, userMessage=$userMessage, errorType=$errorType, error=$error)"
    }
}