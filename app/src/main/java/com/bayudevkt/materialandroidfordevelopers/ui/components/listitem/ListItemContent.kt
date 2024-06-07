package com.bayudevkt.materialandroidfordevelopers.ui.components.listitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.R
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun ListItemContent(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Column {
                ListItem(
                    headlineContent = {
                        Text(text = "A bird flying")
                    }
                )
                HorizontalDivider()
            }
        }

        item {
            Column {
                ListItem(
                    headlineContent = {
                        Text(text = "A bird flying")
                    },
                    overlineContent = {
                        Text(text = "Sunset")
                    },
                )
                HorizontalDivider()
            }
        }

        item {
            Column {
                ListItem(
                    headlineContent = {
                        Text(text = "A bird flying")
                    },
                    overlineContent = {
                        Text(text = "Sunset")
                    },
                    supportingContent = {
                        Text(
                            text = "In hues of gold, the sun descends," +
                                    "A tranquil ocean, its beauty transcends." +
                                    "A solitary bird takes flight," +
                                    "Gracefully dancing in fading light.",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    shadowElevation = 6.dp,
                )
                HorizontalDivider()
            }
        }

        item {
            Column {
                ListItem(
                    headlineContent = {
                        Text(text = "A bird flying")
                    },
                    overlineContent = {
                        Text(text = "Sunset")
                    },
                    supportingContent = {
                        Text(
                            text = "In hues of gold, the sun descends," +
                                    "A tranquil ocean, its beauty transcends." +
                                    "A solitary bird takes flight," +
                                    "Gracefully dancing in fading light.",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    leadingContent = {
                        Image(
                            painter = painterResource(id = R.drawable.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(MaterialTheme.shapes.small),
                        )
                    }
                )
                HorizontalDivider()
            }
        }

        item {
            Column {
                var bookmarked by remember { mutableStateOf(false) }
                ListItem(
                    headlineContent = {
                        Text(text = "A bird flying")
                    },
                    overlineContent = {
                        Text(text = "Sunset")
                    },
                    supportingContent = {
                        Text(
                            text = "In hues of gold, the sun descends," +
                                    "A tranquil ocean, its beauty transcends." +
                                    "A solitary bird takes flight," +
                                    "Gracefully dancing in fading light.",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    leadingContent = {
                        Image(
                            painter = painterResource(id = R.drawable.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(MaterialTheme.shapes.small),
                        )
                    },
                    trailingContent = {
                        IconButton(onClick = { bookmarked = !bookmarked }) {
                            Icon(
                                imageVector = if (bookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = null
                            )
                        }
                    },
                    tonalElevation = 2.dp,
                )
                HorizontalDivider()
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewListItemContent() {
    MaterialAndroidForDevelopersTheme {
        ListItemContent()
    }
}