// This should not be edited instead you can always generate using `source_code_generator.js`.


 object DismissibleNavigationDrawerContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissibleNavigationDrawerContent(
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val drawerItems = remember {
        listOf(Icons.Default.Home, Icons.Default.Favorite, Icons.Default.Settings, Icons.Default.Help)
    }
    var selectedItem by remember { mutableStateOf(drawerItems.first()) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    DismissibleNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            DismissibleDrawerSheet(
                modifier = Modifier,
                drawerTonalElevation = 2.dp,
                drawerShape = MaterialTheme.shapes.large,
            ) {
                drawerItems.forEach { item ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                        label = {
                            Text(text = item.name.uppercase())
                        },
                        selected = item == selectedItem,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                selectedItem = item
                            }
                        },
                        icon = {
                            Icon(imageVector = item, contentDescription = item.name)
                        },
                        shape = MaterialTheme.shapes.medium
                    )
                }
            }
        },
        content = {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                contentWindowInsets = contentWindowInsets,
                topBar = {
                    TopAppBar(
                        title = { Text(text = selectedItem.name) },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    if (drawerState.isOpen) {
                                        drawerState.close()
                                    } else {
                                        drawerState.open()
                                    }
                                }
                            }) {
                                val icon = if (drawerState.currentValue == DrawerValue.Open) {
                                    Icons.Default.Close
                                } else Icons.Default.Menu
                                Icon(
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(imageVector = selectedItem, contentDescription = selectedItem.name)
                        Text(text = selectedItem.name)
                    }
                }
            }
        },
    )
}

     """.trimIndent()
 }