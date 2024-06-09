package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.generate

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddPhotoAlternate
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bayudevkt.materialandroidfordevelopers.core.ui.R
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.colors.Material3ColorItem
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.colors.rememberMaterial3Colors
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component.CodeView
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component.TabComponent
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component.TabComponentSaver
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingsStateHolder
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.Shapes
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.Typography
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.isDarkTheme
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.ui.utils.LargeTopAppBarWithBackButton
import com.bayudevkt.materialandroidfordevelopers.ui.utils.toHexString
import com.materialkolor.PaletteStyle
import com.materialkolor.rememberDynamicColorScheme
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.palette.PalettePlugin
import com.skydoves.landscapist.palette.rememberPaletteState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

val ColorSaver
    get() = listSaver<Color, Any>(
        save = {
            listOf(it.red, it.green, it.blue)
        },
        restore = {
            Color(
                red = it[0] as Float,
                green = it[1] as Float,
                blue = it[2] as Float
            )
        }
    )

val PaletteStyleSaver
    get() = listSaver<PaletteStyle, Any>(
        save = {
            listOf(it.name)
        },
        restore = {
            PaletteStyle.valueOf(it[0] as String)
        }
    )

@Composable
fun GenerateColorsRoute(
    settingsStateHolder: SettingsStateHolder,
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: GenerateColorsViewModel = hiltViewModel()
) {
    GenerateColorsRoute(
        settingsStateHolder = settingsStateHolder,
        selectedImageUri = viewModel.selectedImageUri,
        onBack = onBack,
        onSettingsClicked = onSettingsClicked,
        onSelectedImageUri = viewModel::onSelectedImageUri,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenerateColorsRoute(
    settingsStateHolder: SettingsStateHolder,
    selectedImageUri: Uri?,
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    onSelectedImageUri: (Uri) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    if (selectedImageUri == null) {
        MaterialAndroidForDevelopersTheme(settingsStateHolder = settingsStateHolder) {
            SelectImageContent(
                onBack = onBack,
                onSettingsClicked = onSettingsClicked,
                onSelectedImageUri = onSelectedImageUri,
                scrollBehavior = scrollBehavior,
            )
        }
    } else {
        GenerateColorsContent(
            settingsStateHolder = settingsStateHolder,
            modifier = modifier,
            scrollBehavior = scrollBehavior,
            onBack = onBack,
            onSettingsClicked = onSettingsClicked,
            selectedImageUri = selectedImageUri
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GenerateColorsContent(
    selectedImageUri: Uri?,
    settingsStateHolder: SettingsStateHolder,
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
) {
    val defaultSeedColor = MaterialTheme.colorScheme.primary
    var selectedSeedColor by rememberSaveable(stateSaver = ColorSaver) {
        mutableStateOf(
            defaultSeedColor
        )
    }

    val paletteStyles = remember { PaletteStyle.entries.toList().toImmutableList() }
    var selectedPaletteStyle by rememberSaveable(paletteStyles, stateSaver = PaletteStyleSaver) {
        mutableStateOf(paletteStyles.first())
    }
    val generateColorScheme = rememberDynamicColorScheme(
        seedColor = selectedSeedColor,
        isDark = settingsStateHolder.isDarkTheme,
        style = selectedPaletteStyle
    )
    var selectedTabComponent by rememberSaveable(stateSaver = TabComponentSaver) {
        mutableStateOf(TabComponent.PREVIEW)
    }

    com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme(
        colorScheme = generateColorScheme,
        shapes = settingsStateHolder.Shapes,
        typography = settingsStateHolder.Typography,
    ) {
        Scaffold(
            modifier = modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                Column {
                    LargeTopAppBarWithBackButton(
                        title = stringResource(id = R.string.generate_colors),
                        onBack = onBack,
                        scrollBehavior = scrollBehavior,
                        onSettingsClicked = onSettingsClicked
                    )
                    TabComponent(
                        onSelectedTabComponent = {
                            selectedTabComponent = it
                        },
                        tabs = remember {
                            listOf(TabComponent.PREVIEW, TabComponent.EXPORT)
                        }
                    )
                }
            }
        ) { innerPadding ->
            val reusableModifier = Modifier.padding(innerPadding)
            if (selectedTabComponent == TabComponent.EXPORT) {
                ExportContent(
                    content = rememberExportGeneratedColors(colorScheme = generateColorScheme),
                    modifier = reusableModifier
                )
            } else {
                PreviewContent(
                    colorSchema = generateColorScheme,
                    selectedImageUri = selectedImageUri,
                    seedColor = selectedSeedColor,
                    onChangeSeedColor = { selectedSeedColor = it },
                    paletteStyles = paletteStyles,
                    paletteStyle = selectedPaletteStyle,
                    onChangePaletteStyle = { selectedPaletteStyle = it },
                    modifier = reusableModifier,
                )
            }
        }
    }
}

@Composable
private fun PreviewContent(
    colorSchema: ColorScheme,
    selectedImageUri: Uri?,
    seedColor: Color,
    onChangeSeedColor: (Color) -> Unit,
    paletteStyles: ImmutableList<PaletteStyle>,
    paletteStyle: PaletteStyle,
    onChangePaletteStyle: (PaletteStyle) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = rememberMaterial3Colors(colorSchema)
    val seedColorsLazyListState = rememberLazyListState()
    val paletteStyleLazyListState = rememberLazyListState()
    var palette by rememberPaletteState(value = null)

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(100.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        /* region section selected image */
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.Center
                ) {
                    CoilImage(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .width(120.dp)
                            .aspectRatio(1f / 1f)
                            .clip(MaterialTheme.shapes.medium),
                        imageModel = {
                            selectedImageUri
                        },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                        ),
                        component = rememberImageComponent {
                            +PalettePlugin {
                                palette = it
                            }
                        },
                    )
                    Box(
                        modifier = Modifier
                            .graphicsLayer {
                                translationX = 16.dp.toPx()
                            }
                            .align(Alignment.TopEnd)
                            .size(32.dp)
                            .background(color = seedColor, shape = CircleShape)
                    )
                }
            }
        }
        /* endregion section selected image */

        /* region section seed colors */
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = 16.dp),
                tonalElevation = 2.dp,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                ) {
                    Text(
                        text = stringResource(R.string.seed_colors),
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        state = seedColorsLazyListState,
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        items(palette?.swatches ?: emptyList()) { swatch ->
                            val color = Color(swatch.rgb)
                            Box(
                                modifier = Modifier
                                    .clickable(
                                        role = Role.Button,
                                        onClick = {
                                            onChangeSeedColor(color)
                                        }
                                    )
                                    .size(44.dp)
                                    .background(
                                        color = color,
                                        shape = CircleShape
                                    )
                                    .border(
                                        width = if (seedColor == color) 4.dp else 0.dp,
                                        color = if (seedColor == color) MaterialTheme.colorScheme.onSecondaryContainer else Color.Transparent,
                                        shape = CircleShape,
                                    )
                            )
                        }
                    }
                }
            }
        }
        /* endregion section seed colors */

        /* region section palette style */
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = 16.dp),
                tonalElevation = 2.dp,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                ) {
                    Text(
                        text = stringResource(R.string.palette_style),
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        state = paletteStyleLazyListState,
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        itemsIndexed(paletteStyles) { _, style ->
                            val selected = paletteStyle == style
                            InputChip(
                                selected = selected,
                                onClick = {
                                    onChangePaletteStyle(style)
                                },
                                label = {
                                    Text(text = style.name)
                                }
                            )
                        }
                    }
                }
            }
        }
        /* endregion section palette style */

        /* region section label material 3 colors */
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Text(
                text = stringResource(R.string.material_3_colors),
                modifier = Modifier
                    .padding(top = 16.dp),
                style = MaterialTheme.typography.labelLarge
            )
        }
        /* endregion section label material 3 colors */

        /* region section material 3 colors */
        items(colors) {
            Material3ColorItem(item = it)
        }
        /* endregion section material 3 colors */
    }
}

@Composable
private fun ExportContent(
    content: String,
    modifier: Modifier = Modifier
) {
    CodeView(
        modifier = modifier
            .fillMaxSize(),
        snippetCode = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectImageContent(
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    onSelectedImageUri: (Uri) -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) {
        if (it != null) {
            onSelectedImageUri(it)
        }
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .then(modifier),
        topBar = {
            LargeTopAppBarWithBackButton(
                title = stringResource(id = R.string.generate_colors),
                onBack = onBack,
                scrollBehavior = scrollBehavior,
                onSettingsClicked = onSettingsClicked
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Surface {
                Icon(
                    imageVector = Icons.Rounded.AddPhotoAlternate,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(120.dp),
                )
            }
            ExtendedFloatingActionButton(
                onClick = {
                    launcher.launch(
                        PickVisualMediaRequest(
                            mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly,
                        )
                    )
                }
            ) {
                Text(text = stringResource(R.string.select_image))
            }
        }
    }
}

@Composable
fun rememberExportGeneratedColors(colorScheme: ColorScheme): String {
    return rememberSaveable(colorScheme) {
        exportGeneratedColors(colorScheme)
    }
}

private fun exportGeneratedColors(colorScheme: ColorScheme): String {
    return """
val Primary = Color(${colorScheme.primary.toHexString()})
val OnPrimary = Color(${colorScheme.onPrimary.toHexString()})
val PrimaryContainer = Color(${colorScheme.primaryContainer.toHexString()})
val OnPrimaryContainer = Color(${colorScheme.onPrimaryContainer.toHexString()})
val Secondary = Color(${colorScheme.secondary.toHexString()})
val OnSecondary = Color(${colorScheme.onSecondary.toHexString()})
val SecondaryContainer = Color(${colorScheme.secondaryContainer.toHexString()})
val OnSecondaryContainer = Color(${colorScheme.onSecondaryContainer.toHexString()})
val Tertiary = Color(${colorScheme.tertiary.toHexString()})
val OnTertiary = Color(${colorScheme.onTertiary.toHexString()})
val TertiaryContainer = Color(${colorScheme.tertiaryContainer.toHexString()})
val OnTertiaryContainer = Color(${colorScheme.onTertiaryContainer.toHexString()})
val Error = Color(${colorScheme.error.toHexString()})
val OnError = Color(${colorScheme.onError.toHexString()})
val ErrorContainer = Color(${colorScheme.errorContainer.toHexString()})
val OnErrorContainer = Color(${colorScheme.onErrorContainer.toHexString()})
val Background = Color(${colorScheme.background.toHexString()})
val OnBackground = Color(${colorScheme.onBackground.toHexString()})
val Surface = Color(${colorScheme.surface.toHexString()})
val OnSurface = Color(${colorScheme.onSurface.toHexString()})
val SurfaceVariant = Color(${colorScheme.surfaceVariant.toHexString()})
val OnSurfaceVariant = Color(${colorScheme.onSurfaceVariant.toHexString()})
val Outline = Color(${colorScheme.outline.toHexString()})
    """.trimIndent()
}