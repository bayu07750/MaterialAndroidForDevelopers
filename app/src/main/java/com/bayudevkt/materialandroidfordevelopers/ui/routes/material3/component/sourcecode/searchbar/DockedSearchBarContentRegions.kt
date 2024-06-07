// This should not be edited instead you can always generate using `source_code_generator.js`.


 object DockedSearchBarContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DockedSearchBarContent(
    modifier: Modifier = Modifier,
    data: List<String> = remember { DataDummy.listProgrammingLanguages },
    windowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val lazyListState = rememberLazyListState()
    var items by remember(data) { mutableStateOf(data) }
    val itemsHistorySearch = remember { mutableStateListOf("c", "java") }
    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        contentWindowInsets = windowInsets,
        topBar = {
            var text by remember { mutableStateOf("") }
            var active by remember { mutableStateOf(false) }

            DockedSearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                query = text,
                onQueryChange = { text = it },
                onSearch = { query ->
                    active = false
                    items = data.filter { it.contains(query, true) }
                    if (itemsHistorySearch.indexOf(query) == -1) {
                        itemsHistorySearch.add(query)
                    }
                },
                active = active,
                onActiveChange = { active = it },
                placeholder = {
                    Text(text = "Search")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search Icon"
                    )
                },
                trailingIcon = {
                    if (active) {
                        IconButton(
                            onClick = {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    active = false
                                    items = data
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Rounded.Close, contentDescription = "Close Icon")
                        }
                    }
                },
                content = {
                    itemsHistorySearch.take(5).reversed().forEach { item ->
                        key(item) {
                            Surface(modifier = Modifier) {
                                Row(
                                    modifier = Modifier
                                        .clickable(
                                            role = Role.Button,
                                        ) {
                                            active = false
                                            text = item
                                            items = data.filter { it.contains(item, true) }
                                        }
                                        .semantics {
                                            contentDescription = 
                                        }
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.History,
                                        contentDescription = "History Icon"
                                    )
                                    Text(
                                        text = item,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            state = lazyListState,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = items, key = { it }) { item ->
                Surface(
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(context, item, Toast.LENGTH_SHORT)
                                .show()
                        }
                        .animateItemPlacement(),
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 3.dp,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

     """.trimIndent()
 }