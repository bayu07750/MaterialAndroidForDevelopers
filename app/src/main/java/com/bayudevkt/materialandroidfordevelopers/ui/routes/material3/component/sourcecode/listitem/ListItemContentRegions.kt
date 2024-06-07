// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ListItemContentSourceCode {
 
     val code get() = """
 
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

     """.trimIndent()
 }