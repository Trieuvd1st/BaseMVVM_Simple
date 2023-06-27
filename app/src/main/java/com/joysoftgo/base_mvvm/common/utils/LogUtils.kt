package com.joysoftgo.base_mvvm.common.utils

import android.util.Log
import com.joysoftgo.base_mvvm.BuildConfig

private const val KEY_LOG = "DEBUG_LOG"

fun Logd(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(KEY_LOG, message)
    }
}

fun Loge(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(KEY_LOG, message)
    }
}

fun Logi(message: String) {
    if (BuildConfig.DEBUG) {
        Log.i(KEY_LOG, message)
    }
}

fun Logv(message: String) {
    if (BuildConfig.DEBUG) {
        Log.v(KEY_LOG, message)
    }
}

fun Logw(message: String) {
    if (BuildConfig.DEBUG) {
        Log.w(KEY_LOG, message)
    }
}