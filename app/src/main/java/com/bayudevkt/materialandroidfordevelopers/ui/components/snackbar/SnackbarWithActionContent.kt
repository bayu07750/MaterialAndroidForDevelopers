package com.bayudevkt.materialandroidfordevelopers.ui.components.snackbar

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SnackbarResult.Dismissed
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import kotlinx.coroutines.launch

/* region */
@Composable
fun SnackbarWithActionContent(
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val showSnackbar: (String) -> Unit = { message: String ->
        scope.launch {
            val snackbarResult = snackbarHostState.showSnackbar(
                message,
                actionLabel = "OK",
                withDismissAction = true,
            )
            when (snackbarResult) {
                Dismissed -> {
                    Toast.makeText(context, "Dismissed", Toast.LENGTH_SHORT).show()
                }

                SnackbarResult.ActionPerformed -> {
                    Toast.makeText(context, "Clicked OK", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPad ->
        Column(
            modifier = Modifier
                .padding(innerPad)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            var message by remember { mutableStateOf("") }
            TextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                label = {
                    Text(text = "Your Message to the World")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    showSnackbar(message)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            ) {
                Text(text = "Send message")
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewSnackbarWithActionContent() {
    MaterialAndroidForDevelopersTheme {
        SnackbarWithActionContent()
    }
}