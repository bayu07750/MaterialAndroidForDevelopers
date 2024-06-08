package com.bayudevkt.materialandroidfordevelopers.m3components.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.PlaylistAdd
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.LibraryAdd
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.WatchLater

object DataDummy {

    val listProgrammingLanguages get() = listOf(
        "kotlin",
        "java",
        "python",
        "c++",
        "javascript",
        "swift",
        "ruby",
        "go",
        "rust",
        "php",
        "typescript",
        "c#",
        "scala",
        "r",
        "perl",
        "lua",
        "html",
        "css",
        "sql",
        "dart"
    )

    val dataDropdownMenu get() = listOf(
        DataDropdownMenu("Play next in queue", Icons.AutoMirrored.Filled.PlaylistAdd),
        DataDropdownMenu("Save to watch later", Icons.Default.WatchLater),
        DataDropdownMenu("Save to playlist", Icons.Default.LibraryAdd),
        DataDropdownMenu("Download", Icons.Default.Download),
        DataDropdownMenu("Share", Icons.Default.Share),
        DataDropdownMenu("Report", Icons.Default.Report),
    )

    val listColors get() = listOf(
        "9C27B0",
        "2196F3",
        "00BCD4",
        "E91E63",
        "CDDC39",
        "FF9800",
        "3F51B5",
        "4CAF50",
        "CDDC39",
    )
}