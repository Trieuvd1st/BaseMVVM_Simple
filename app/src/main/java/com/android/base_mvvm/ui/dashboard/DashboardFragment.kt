package com.android.base_mvvm.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.android.base_mvvm.R
import com.android.base_mvvm.databinding.FragmentDashboardBinding
import com.android.base_mvvm.utils.onClick
import com.android.base_mvvm.ui.base.BaseFragment
import com.android.base_mvvm.ui.tabVideo.VideoFragment
import com.android.base_mvvm.ui.tabfile.FileFragment
import com.android.base_mvvm.ui.tabimage.PhotoFragment
import com.android.base_mvvm.utils.ext.handleReplace
import com.android.base_mvvm.utils.ext.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)

    private val viewModel by viewModels<DashboardViewModel>()


    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun bindingStateView() {

    }

    override fun setOnClick() {
        binding.btnPhoto.onClick {
            requireActivity().supportFragmentManager.handleReplace(containerId = R.id.mainContainer, fragment = PhotoFragment())
        }

        binding.btnVideo.onClick {
            requireActivity().supportFragmentManager.handleReplace(containerId = R.id.mainContainer, fragment = VideoFragment())        }

        binding.btnFile.onClick {
            requireActivity().supportFragmentManager.handleReplace(containerId = R.id.mainContainer, fragment = FileFragment())        }
    }
}