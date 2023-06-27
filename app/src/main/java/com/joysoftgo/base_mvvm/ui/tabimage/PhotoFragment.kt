package com.joysoftgo.base_mvvm.ui.tabimage

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.joysoftgo.base_mvvm.databinding.FragmentPhotoBinding
import com.joysoftgo.base_mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : BaseFragment<FragmentPhotoBinding>(FragmentPhotoBinding::inflate) {

    private val viewModel by viewModels<PhotoViewModel>()

    override fun initView(savedInstanceState: Bundle?) {
    }
}