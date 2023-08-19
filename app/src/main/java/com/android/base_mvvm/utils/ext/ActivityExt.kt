package com.android.base_mvvm.utils.ext

import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


fun FragmentActivity.popBackStack() = supportFragmentManager.popBackStack()

private const val THRESHOLD_FINISH_TIME = 2000
private var backPressedTime = 0L
val isBackPressFinish: Boolean
    get() {
        // preventing finish, using threshold of 2000 ms
        if (backPressedTime + THRESHOLD_FINISH_TIME > SystemClock.elapsedRealtime()) {
            return true
        }

        backPressedTime = SystemClock.elapsedRealtime()
        return false
    }


inline fun <T : Any> AppCompatActivity.collectFlowOn(
    stateFlow: StateFlow<T>,
    lifecycleState: Lifecycle.State = Lifecycle.State.CREATED,
    crossinline onResult: (t: T) -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(lifecycleState) {
            stateFlow.collect {
                onResult.invoke(it)
            }
        }
    }
}

