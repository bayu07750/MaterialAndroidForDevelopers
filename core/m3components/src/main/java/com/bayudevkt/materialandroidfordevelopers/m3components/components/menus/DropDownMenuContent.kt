package com.bayudevkt.materialandroidfordevelopers.m3components.components.menus

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.m3components.utils.DataDropdownMenu
import com.bayudevkt.materialandroidfordevelopers.m3components.utils.DataDummy

/* region */
@Composable
fun DropDownMenuContent(
    modifier: Modifier = Modifier,
    data: List<DataDropdownMenu> = remember {
        DataDummy.dataDropdownMenu
    }
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var open by remember { mutableStateOf(false) }
        val context = LocalContext.current
        Button(onClick = {
            open = true
        }) {
            Text(text = "Show Dropdown Menu")
        }
        DropdownMenu(
            modifier = Modifier,
            expanded = open,
            onDismissRequest = { open = false },
            properties = PopupProperties(),
            content = {
                data.forEachIndexed { index, menu ->
                    DropdownMenuItem(
                        text = {
                            Text(text = menu.text)
                        },
                        onClick = {
                            Toast.makeText(context, menu.text, Toast.LENGTH_SHORT).show()
                            open = false
                        },
                        leadingIcon = {
                            Icon(imageVector = menu.icon, contentDescription = menu.icon.name)
                        },
                        trailingIcon = {
                            if (index == 0) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
                            }
                        },
                        enabled = index != data.lastIndex,
                        contentPadding = PaddingValues(horizontal = 24.dp)
                    )
                }
            }
        )
    }
}
/* endregion */
@Preview(showBackground = true)
@Composable
fun PreviewDropDownMenuContent() {
    MaterialAndroidForDevelopersTheme {
        DropDownMenuContent()
    }
}