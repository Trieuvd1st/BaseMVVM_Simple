package com.android.base_mvvm.ui.tabVideo

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.android.base_mvvm.R
import com.android.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment: BaseFragment(R.layout.fragment_video) {

    private val viewModel by viewModels<VideoViewModel>()

    override fun initView(savedInstanceState: Bundle?) {

    }
}