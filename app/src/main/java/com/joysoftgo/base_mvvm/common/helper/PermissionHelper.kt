package com.joysoftgo.base_mvvm.common.helper

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

object PermissionHelper {

    fun checkFingerPrintPermission(context: Context): Boolean {
        val useFingerPrint = context.checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED
        val useBiometric = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            context.checkSelfPermission(Manifest.permission.USE_BIOMETRIC) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
        return useFingerPrint && useBiometric
    }
}