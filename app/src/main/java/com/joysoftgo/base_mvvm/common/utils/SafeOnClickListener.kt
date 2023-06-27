package com.joysoftgo.base_mvvm.common.utils

import android.os.SystemClock
import android.view.View

/**
 * This is a custom clicklistener to prevent multiple click events to happens at the same time.
 *
 * Each click on a button is added in the internal event handler queue, there is no way to remove
 * them from there so the only thing we can do is adding a filter to prevent them to run too
 * frequently
 *
 * In RxJava this could be achieved using RxBinding and throttleFirst operator
 *
 * Base implementation took from here: https://stackoverflow.com/a/20672997/2910520
 */
abstract class SafeOnClickListener @JvmOverloads constructor(
    private val minClickInterval: Long = 500 // default value for min-click time
) : View.OnClickListener {

    /**
     * The time the last click was applied
     */
    private var mLastClickTime: Long = 0

    /**
     * @param v The view that was clicked.
     */
    abstract fun onSingleClick(v: View?)

    override fun onClick(v: View?) {
        val currentClickTime: Long = SystemClock.elapsedRealtime()
        val elapsedTime = currentClickTime - mLastClickTime
        if (elapsedTime <= minClickInterval) return
        mLastClickTime = currentClickTime
        onSingleClick(v)
    }
}

// Extension (optional but useful):
fun View.onClick(millis: Long = 300, action: (v: View?) -> Unit) {
    setOnClickListener(object : SafeOnClickListener(millis) {
        override fun onSingleClick(v: View?) {
            action(v)
        }
    })
}
