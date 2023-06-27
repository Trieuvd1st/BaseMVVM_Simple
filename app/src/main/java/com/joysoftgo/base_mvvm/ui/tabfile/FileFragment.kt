package com.joysoftgo.base_mvvm.ui.tabfile

import androidx.fragment.app.viewModels
import com.joysoftgo.base_mvvm.databinding.FragmentFileBinding
import com.joysoftgo.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FileFragment: BaseFragment<FragmentFileBinding>(FragmentFileBinding::inflate) {

    private val viewModel by viewModels<FileViewModel>()
}