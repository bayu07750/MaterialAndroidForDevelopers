package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.generate

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GenerateColorsViewModel @Inject constructor() : ViewModel() {

    var selectedImageUri by mutableStateOf<Uri?>(null)
        private set

    fun onSelectedImageUri(uri: Uri) {
        selectedImageUri = uri
    }
}