package com.bayudevkt.materialandroidfordevelopers.ui.routes.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.toImmutableList

enum class ShapeSetting {
    Rounded,
    Cut,
    None
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShapeSettingContent(
    currentShapeSetting: ShapeSetting,
    onChangeShapeSetting: (ShapeSetting) -> Unit,
    modifier: Modifier = Modifier,
) {
    val shapeSettingOptions = remember {
        ShapeSetting.entries.toImmutableList()
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        SingleChoiceSegmentedButtonRow {
            shapeSettingOptions.forEachIndexed { index, shapeSetting ->
                val selected = currentShapeSetting == shapeSetting
                SegmentedButton(
                    selected = selected,
                    onClick = {
                        onChangeShapeSetting(shapeSetting)
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = shapeSettingOptions.size),
                ) {
                    Text(text = shapeSetting.name)
                }
            }
        }
    }
}