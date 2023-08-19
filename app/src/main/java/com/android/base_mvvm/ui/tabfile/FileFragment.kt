package com.android.base_mvvm.ui.tabfile

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.android.base_mvvm.R
import com.android.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FileFragment : BaseFragment(R.layout.fragment_file) {

    private val viewModel by viewModels<FileViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
    }
}