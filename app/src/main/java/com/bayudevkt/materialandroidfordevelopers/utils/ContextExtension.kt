package com.bayudevkt.materialandroidfordevelopers.utils

import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.Toast
import com.bayudevkt.materialandroidfordevelopers.R

fun Context.copyText(value: String) {
    getSystemService(ClipboardManager::class.java)?.let { cm ->
        cm.setPrimaryClip(ClipData.newPlainText("", value))
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
            Toast.makeText(this, getString(R.string.copied), Toast.LENGTH_SHORT).show()
        }
    }
}

fun Context.openUrl(url: String) {
    Intent().apply {
        action = Intent.ACTION_VIEW
        data = Uri.parse(url)
    }.also { intent ->
        try {
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {

        }
    }
}