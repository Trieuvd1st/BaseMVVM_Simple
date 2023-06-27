package com.joysoftgo.base_mvvm.ui.base

import androidx.lifecycle.ViewModel
import com.joysoftgo.base_mvvm.common.utils.Logd
import com.joysoftgo.base_mvvm.common.utils.Loge
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Loge("COROUTINE EXCEPTION: $throwable")
    }
}