package com.joysoftgo.base_mvvm.ui.tabVideo

import androidx.fragment.app.viewModels
import com.joysoftgo.base_mvvm.databinding.FragmentVideoBinding
import com.joysoftgo.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment: BaseFragment<FragmentVideoBinding>(FragmentVideoBinding::inflate) {

    private val viewModel by viewModels<VideoViewModel>()
}