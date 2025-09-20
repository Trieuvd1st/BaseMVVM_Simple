package com.android.base_mvvm.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(app: Application) : AndroidViewModel(app) {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    }

    val context by lazy { app.applicationContext }
}