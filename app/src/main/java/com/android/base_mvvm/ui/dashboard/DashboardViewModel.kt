package com.android.base_mvvm.ui.dashboard

import android.app.Application
import com.android.base_mvvm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val app: Application) : BaseViewModel(app) {
}