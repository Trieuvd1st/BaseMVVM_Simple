package com.joysoftgo.base_mvvm.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.joysoftgo.base_mvvm.R
import com.joysoftgo.base_mvvm.common.utils.onClick
import com.joysoftgo.base_mvvm.databinding.FragmentDashboardBinding
import com.joysoftgo.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {

    private val viewModel by viewModels<DashboardViewModel>()


    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun bindingStateView() {

    }

    override fun setOnClick() {
        binding.btnPhoto.onClick {
            navController.navigate(R.id.action_dashboardFragment_to_photoFragment)
        }

        binding.btnVideo.onClick {
            navController.navigate(R.id.action_dashboardFragment_to_videoFragment)
        }

        binding.btnFile.onClick {
            navController.navigate(R.id.action_dashboardFragment_to_fileFragment)
        }
    }
}