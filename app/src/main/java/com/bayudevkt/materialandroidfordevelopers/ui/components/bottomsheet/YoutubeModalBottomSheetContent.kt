package com.bayudevkt.materialandroidfordevelopers.ui.components.bottomsheet

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bayudevkt.materialandroidfordevelopers.R
import com.bayudevkt.materialandroidfordevelopers.ui.utils.DataDummy
import com.bayudevkt.materialandroidfordevelopers.ui.utils.DataDropdownMenu
import kotlinx.coroutines.launch

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YoutubeModalBottomSheetContent(
    modifier: Modifier = Modifier,
    options: List<DataDropdownMenu> = remember { DataDummy.dataDropdownMenu }
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var openBottomState by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(10) {
            YoutubeItem(
                onMenuClicked = {
                    openBottomState = true
                }
            )
        }
    }

    if (openBottomState) {
        ModalBottomSheet(
            onDismissRequest = {
                openBottomState = false
            },
            content = {
                options.forEach { data ->
                    DropdownMenuItem(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                        text = {
                            Text(text = data.text)
                        },
                        onClick = {
                            scope.launch {
                                Toast.makeText(context, data.text, Toast.LENGTH_SHORT).show()
                                sheetState.hide()
                            }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    openBottomState = false
                                }
                            }
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = data.icon,
                                contentDescription = null
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            },
            sheetState = sheetState,
        )
    }
}

@Composable
fun YoutubeItem(
    onMenuClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 200.dp),
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Surface(
                    modifier = Modifier
                        .padding(bottom = 8.dp, end = 8.dp)
                        .align(Alignment.BottomEnd),
                    shape = MaterialTheme.shapes.small,
                    color = Color.Black,
                    contentColor = Color.White,
                ) {
                    Text(
                        modifier = Modifier.padding(all = 4.dp),
                        text = "27:09",
                        fontSize = 12.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column {
                        Text(
                            text = "A bird flying sunset",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Text(text = "Person - 94K - 1 hour ago")
                    }
                }
                IconButton(onClick = onMenuClicked) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
/* endregion */
