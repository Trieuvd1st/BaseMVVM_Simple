package com.android.base_mvvm.ui

import android.os.Bundle
import androidx.core.view.isVisible
import com.android.base_mvvm.R
import com.android.base_mvvm.databinding.ActivityMainBinding
import com.example.base.ext.viewBinding
import com.android.base_mvvm.ui.base.BaseActivity
import com.android.base_mvvm.ui.splash.SplashFragment
import com.android.base_mvvm.utils.ext.handleReplace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.handleReplace(containerId = R.id.mainContainer, fragment = SplashFragment())
    }

    fun showHideLoading(isShow: Boolean) {
        binding.pbLoading.isVisible = isShow
        binding.bgLoading.isVisible = isShow
    }
}