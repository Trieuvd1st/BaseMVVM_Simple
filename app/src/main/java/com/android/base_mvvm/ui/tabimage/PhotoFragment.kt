package com.android.base_mvvm.ui.tabimage

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.android.base_mvvm.R
import com.android.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : BaseFragment(R.layout.fragment_photo) {

    private val viewModel by viewModels<PhotoViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
    }
}