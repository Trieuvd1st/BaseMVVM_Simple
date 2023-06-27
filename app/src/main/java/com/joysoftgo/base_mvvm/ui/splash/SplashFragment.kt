package com.joysoftgo.base_mvvm.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.viewModels
import com.joysoftgo.base_mvvm.R
import com.joysoftgo.base_mvvm.databinding.FragmentSplashBinding
import com.joysoftgo.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private val viewModel by viewModels<SplashViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(R.id.action_splashFragment_to_dashboardFragment)
        }, 2000)
    }
}