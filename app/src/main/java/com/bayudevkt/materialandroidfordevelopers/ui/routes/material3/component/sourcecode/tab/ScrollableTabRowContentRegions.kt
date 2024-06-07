// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ScrollableTabRowContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollableTabRowContent(
    modifier: Modifier = Modifier,
) {
    val tabs = remember {
        listOf(
            "Trending" to Icons.Rounded.Explore,
            "Music" to Icons.Rounded.LibraryMusic,
            "Game" to Icons.Rounded.Games,
            "Movie" to Icons.Rounded.Movie,
            "Search" to Icons.Rounded.Search,
            "Gallery" to Icons.Rounded.Image
        )
    }
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    Column(
        modifier = modifier,
    ) {
        Text(text = "TabRow")
        ScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            tabs = {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = { Text(text = tab.first) }
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "SecondaryTabRow")
        SecondaryScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            tabs = {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = { Text(text = tab.first) }
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "PrimaryTabRow")
        PrimaryScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            tabs = {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = { Text(text = tab.first) }
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "TabRow with Icon")
        ScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            tabs = {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = { Text(text = tab.first) },
                        icon = {
                            Icon(
                                imageVector = tab.second,
                                contentDescription = null
                            )
                        }
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "TabRow with Custom Indicator")
        ScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            tabs = {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = { Text(text = tab.first) },
                    )
                }
            },
            indicator = { positions ->
                if (selectedTabIndex < positions.size) {
                    Box(
                        Modifier
                            .tabIndicatorOffset(positions[selectedTabIndex])
                            .padding(4.dp)
                            .fillMaxSize()
                            .border(width = 2.dp, color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                    )
                }
            }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = tabs[selectedTabIndex].first)
        }
    }
}

     """.trimIndent()
 }