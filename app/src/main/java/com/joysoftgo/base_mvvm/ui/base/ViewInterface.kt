package com.joysoftgo.base_mvvm.ui.base

import android.os.Bundle

interface ViewInterface {
    fun setOnClick()
    fun initView(savedInstanceState: Bundle?)
    fun bindingStateView()
    fun bindingAction()
}
