package com.android.base_mvvm.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.viewModels
import com.android.base_mvvm.R
import com.android.base_mvvm.databinding.FragmentSplashBinding
import com.android.base_mvvm.ui.base.BaseFragment
import com.android.base_mvvm.ui.dashboard.DashboardFragment
import com.android.base_mvvm.utils.ext.handleReplace
import com.android.base_mvvm.utils.ext.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)
    private val viewModel by viewModels<SplashViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
            requireActivity().supportFragmentManager.handleReplace(containerId = R.id.mainContainer, fragment = DashboardFragment())
        }, 1000)
    }
}