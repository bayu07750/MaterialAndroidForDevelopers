// This should not be edited instead you can always generate using `source_code_generator.js`.


 object NavigationBarContentSourceCode {
 
     val code get() = """
 
@Composable
fun NavigationBarContent(
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val items = remember {
        listOf(
            Icons.Default.Home to "Home",
            Icons.Default.Explore to "Explore",
            Icons.Default.Subscriptions to "Subscriptions",
            Icons.Default.VideoLibrary to "Library",
        )
    }
    var selectedLibrary by remember { mutableStateOf(items.first().second) }
    Scaffold(
        modifier = modifier,
        contentWindowInsets = contentWindowInsets,
        bottomBar = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                NavigationBar {
                    items.forEach { item ->
                        NavigationBarItem(
                            selected = item.second == selectedLibrary,
                            onClick = {
                                selectedLibrary = item.second
                            },
                            icon = {
                                Icon(imageVector = item.first, contentDescription = item.second)
                            },
                            label = {
                                Text(text = item.second)
                            },
                            alwaysShowLabel = true,
                        )
                    }
                }
                NavigationBar {
                    items.forEach { item ->
                        NavigationBarItem(
                            selected = item.second == selectedLibrary,
                            onClick = {
                                selectedLibrary = item.second
                            },
                            icon = {
                                Icon(imageVector = item.first, contentDescription = item.second)
                            },
                            label = {
                                Text(text = item.second)
                            },
                            alwaysShowLabel = false,
                        )
                    }
                }
                NavigationBar {
                    items.forEach { item ->
                        NavigationBarItem(
                            selected = item.second == selectedLibrary,
                            onClick = {
                                selectedLibrary = item.second
                            },
                            icon = {
                                Icon(imageVector = item.first, contentDescription = item.second)
                            },
                            label = {
                                Text(text = item.second)
                            },
                            alwaysShowLabel = false,
                            enabled = false
                        )
                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = selectedLibrary)
        }
    }
}

     """.trimIndent()
 }