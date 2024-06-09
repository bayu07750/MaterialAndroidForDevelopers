package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Collections
import androidx.compose.material.icons.rounded.ColorLens
import androidx.compose.material.icons.rounded.Colorize
import androidx.compose.material.icons.rounded.TextFields
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.R
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.ui.utils.MainLargeTopAppBar

val TopRoundedCornerShape
    @Composable
    get() = MaterialTheme.shapes.large.copy(bottomStart = CornerSize(0.dp), bottomEnd = CornerSize(0.dp))
val BottomRoundedCornerShape
    @Composable
    get() = MaterialTheme.shapes.large.copy(topStart = CornerSize(0.dp), topEnd = CornerSize(0.dp))
val FullRoundedCornerShape
    @Composable
    get() = MaterialTheme.shapes.large

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun defaultLargeTopAppBarColors(): TopAppBarColors {
    return TopAppBarDefaults.largeTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        scrolledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        actionIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
    )
}

@Composable
fun Material3Route(
    onComponentsClicked: () -> Unit,
    onColorsClicked: () -> Unit,
    onTypographyClicked: () -> Unit,
    onGenerateColorsClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Material3Route(
        onComponentsClicked = onComponentsClicked,
        onColorsClicked = onColorsClicked,
        onTypographyClicked = onTypographyClicked,
        onGenerateColorsClicked = onGenerateColorsClicked,
        onSettingsClicked = onSettingsClicked,
        modifier = modifier,
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Material3Route(
    onSettingsClicked: () -> Unit,
    onComponentsClicked: () -> Unit,
    onColorsClicked: () -> Unit,
    onTypographyClicked: () -> Unit,
    onGenerateColorsClicked: () -> Unit,
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        contentWindowInsets = contentWindowInsets,
        topBar = {
            MainLargeTopAppBar(
                title = stringResource(id = R.string.app_name),
                scrollBehavior = scrollBehavior,
                onSettingsClicked = onSettingsClicked
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .padding(top = 16.dp)
                .fillMaxSize(),
        ) {
            AppListItem(
                title = stringResource(R.string.components),
                description = stringResource(R.string.all_available_components_for_material_3),
                icon = Icons.Rounded.Collections,
                onClick = onComponentsClicked,
                shape = TopRoundedCornerShape
            )
            AppListItem(
                title = stringResource(R.string.colors),
                description = stringResource(R.string.colors_schema_for_material_3),
                icon = Icons.Rounded.ColorLens,
                onClick = onColorsClicked,
            )
            AppListItem(
                title = stringResource(R.string.typography),
                description = stringResource(R.string.typography_schema_for_material_3),
                icon = Icons.Rounded.TextFields,
                onClick = onTypographyClicked,
                shape = BottomRoundedCornerShape,
                divider = false,
            )

            Spacer(modifier = Modifier.height(24.dp))
            AppListItem(
                title = stringResource(R.string.generate_colors),
                description = stringResource(R.string.use_your_image_to_generate_colors_schema_for_material_3),
                icon = Icons.Rounded.Colorize,
                onClick = onGenerateColorsClicked,
                shape = FullRoundedCornerShape,
                divider = false,
            )
        }
    }
}

@Composable
fun AppListItem(
    title: String,
    description: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(0.dp),
    enabled: Boolean = true,
    divider: Boolean = true,
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp),
        onClick = onClick,
        shape = shape,
        enabled = enabled,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    ) {
        AppListItemContent(
            divider = divider,
            icon = icon,
            title = title,
            description = description
        )
    }
}

@Composable
fun AppOutlinedListItem(
    title: String,
    description: String,
    icon: ImageVector?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(0.dp),
    enabled: Boolean = true,
    divider: Boolean = true,
) {
    OutlinedCard(
        modifier = modifier
            .padding(horizontal = 16.dp),
        onClick = onClick,
        shape = shape,
        enabled = enabled,
        colors = CardDefaults.outlinedCardColors()
    ) {
        AppListItemContent(
            divider = divider,
            icon = icon,
            title = title,
            description = description
        )
    }
}

@Composable
private fun AppListItemContent(
    divider: Boolean,
    icon: ImageVector?,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(83.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (divider) 82.dp else 83.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (icon != null){
                Icon(imageVector = icon, contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))
            }
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    modifier = Modifier
                        .basicMarquee(),
                )
                if (description.isNotEmpty()) {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
        if (divider) {
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier
                    .padding(start = (16 + 12 + 24).dp, end = 16.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMaterial3Route() {
    MaterialAndroidForDevelopersTheme {
        Material3Route(
            onComponentsClicked = {},
            onColorsClicked = {},
            onTypographyClicked = {},
            onGenerateColorsClicked = {},
            onSettingsClicked = {}
        )
    }
}