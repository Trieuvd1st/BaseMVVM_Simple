package com.joysoftgo.base_mvvm.ui.tabimage

import androidx.lifecycle.viewModelScope
import com.joysoftgo.base_mvvm.domain.repository.DataStoreRepository
import com.joysoftgo.base_mvvm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor() : BaseViewModel() {

    init {
        viewModelScope.launch(exceptionHandler) {
            //TODO SOMETHING WITH ASYNC
        }
    }

}