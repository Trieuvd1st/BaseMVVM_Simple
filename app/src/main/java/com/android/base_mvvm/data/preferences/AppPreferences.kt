package com.android.base_mvvm.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
) {
    companion object {
        private const val SHARED_NAME = "private_shared"
    }

    private val prefs: SharedPreferences =
        applicationContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    fun clear() {
        prefs.edit { clear() }
    }

    fun remove(key: String) {
        prefs.edit { remove(key) }
    }

    var password by prefs.string()
}