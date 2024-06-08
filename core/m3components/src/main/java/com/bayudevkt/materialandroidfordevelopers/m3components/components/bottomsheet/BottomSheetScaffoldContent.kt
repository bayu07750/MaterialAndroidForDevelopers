package com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomsheet

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.core.ui.R
import kotlinx.coroutines.launch

/* region */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun BottomSheetScaffoldContent(
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded,
            skipHiddenState = true,
        ),
        snackbarHostState = snackbarHostState,
    )
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetContent = {
            val padModifier = Modifier
                .padding(horizontal = 16.dp)
            Text(
                modifier = padModifier,
                text = "A bird flying over the ocean at sunset photo",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider(modifier = padModifier)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = padModifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(text = "Views", style = MaterialTheme.typography.bodySmall)
                    Text(text = "226,295", style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = "Downloads", style = MaterialTheme.typography.bodySmall)
                    Text(text = "1,870", style = MaterialTheme.typography.bodyLarge)
                }
                Column {
                    Text(text = "Features In", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Editorial", style = MaterialTheme.typography.bodyLarge)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = padModifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape),
                    tint = Color.Blue.copy(alpha = 0.5f)
                )
                Text(text = "Gred Bulla - On Unsplash", style = MaterialTheme.typography.labelLarge)
            }
            Spacer(modifier = Modifier.height(12.dp))
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(20) {
                    Image(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(MaterialTheme.shapes.medium),
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        },
        sheetPeekHeight = 200.dp,
        sheetShape = MaterialTheme.shapes.large,
        sheetDragHandle = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(text = "swipe me!")
                BottomSheetDefaults.DragHandle()
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = it) { data ->
                Snackbar(
                    snackbarData = data,
                    shape = CircleShape,
                    containerColor = BottomSheetDefaults.ContainerColor,
                    contentColor = MaterialTheme.colorScheme.contentColorFor(BottomSheetDefaults.ContainerColor),
                    dismissActionContentColor = MaterialTheme.colorScheme.contentColorFor(BottomSheetDefaults.ContainerColor),
                    actionColor = MaterialTheme.colorScheme.primary
                )
            }
        },
        topBar = {
            TopAppBar(title = { Text(text = "Demo BottomSheetScaffold") })
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Image(
                modifier = Modifier
                    .combinedClickable(
                        onClick = {
                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    "Snackbar",
                                    actionLabel = "OK",
                                    withDismissAction = true
                                )
                                when (result) {
                                    SnackbarResult.Dismissed -> {
                                        Toast
                                            .makeText(context, "Close", Toast.LENGTH_SHORT)
                                            .show()
                                    }

                                    SnackbarResult.ActionPerformed -> {
                                        Toast
                                            .makeText(context, "OK", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            }
                        },
                        onLongClick = {

                        }
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Try to click or long click image",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White.copy(alpha = .5f)
            )
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheetScaffoldContent() {
    MaterialAndroidForDevelopersTheme {
        BottomSheetScaffoldContent()
    }
}