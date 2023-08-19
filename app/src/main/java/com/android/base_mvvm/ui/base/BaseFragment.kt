package com.android.base_mvvm.ui.base

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.android.base_mvvm.utils.ext.popBackStack

abstract class BaseFragment(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    open val isHandleBackPress = true

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            this@BaseFragment.handleOnBackPressed()
        }
    }

    open fun handleOnBackPressed() {
        requireActivity().popBackStack()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isHandleBackPress) {
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                onBackPressedCallback
            )
        }

        initView(savedInstanceState)

        setOnClick()

        bindingStateView()

        bindingAction()
    }

    abstract fun initView(savedInstanceState: Bundle?)

    open fun setOnClick() {}

    open fun bindingStateView() {}

    open fun bindingAction() {}

    override fun onStart() {
        Glide.with(this).onStart()
        super.onStart()
    }

    override fun onStop() {
        Glide.with(this).onStop()
        super.onStop()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Glide.with(this).onConfigurationChanged(newConfig)
        super.onConfigurationChanged(newConfig)
    }

    override fun onDestroyView() {
        try {
            Glide.with(this).onDestroy()
        } catch (_: Exception) {
        }
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}