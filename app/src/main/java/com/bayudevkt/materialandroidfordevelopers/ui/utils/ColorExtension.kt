package com.bayudevkt.materialandroidfordevelopers.ui.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

fun Color.toHex(): String =
    String.format(
        "#%08X",
        (0xFFFFFFFF and this.toArgb().toLong())
    ).replace("#FF", "#")

fun Color.toHexString() =
    toHex().replace(oldValue = "#", newValue = "0xFF")